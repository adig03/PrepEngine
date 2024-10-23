package com.example.codemastery.Quizes.Fragments

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.codemastery.Models.QuestionModel
import com.example.codemastery.R
import com.example.codemastery.databinding.FragmentQuizQuesBinding
import com.example.codemastery.databinding.ScoreDialogBinding

import com.example.codemastery.main.MainActivity

class QuizQuesFragment : Fragment(R.layout.fragment_quiz_ques) {

    private lateinit var binding: FragmentQuizQuesBinding
    private var currentIndex = 0
    private var score :Int = 0

    companion object {
        var questionModelList: List<QuestionModel> = listOf()
        var timer = ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz_ques, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.toolbar.setNavigationOnClickListener {

            exitQuiz()

        }

        loadQuestion(currentIndex)
        setButtonClickListeners()

        binding.apply {
            nextBtn.setOnClickListener {
                resetButtons()

                if (currentIndex < questionModelList.size - 1) {
                    currentIndex++
                    loadQuestion(currentIndex)
                } else {
                   finishQuiz()
                }
            }

            startTimer()// Start the countdown timer
        }
        handleBackPress()
    }

    private fun exitQuiz() {
        val builder = androidx.appcompat.app.AlertDialog.Builder(requireContext())
        builder.setTitle("Seriously?")
        builder.setMessage("Are you sure you want to go back? Your current progress might be lost?")
        builder.setPositiveButton("Yes") { dialog, _ ->
            finishQuiz()
            dialog.dismiss()

        }
        builder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }
        builder.create().show()
    }

    // Function to load question and update UI elements
    private fun loadQuestion(currentIndex: Int) {
        binding.apply {
            toolbar.title = "Question ${currentIndex + 1} / ${questionModelList.size}"
            questionProgressIndicator.progress =
                ((currentIndex + 1).toFloat() / questionModelList.size.toFloat() * 100).toInt()
            questionTextview.text = questionModelList[currentIndex].question

            btn0.text = questionModelList[currentIndex].options[0]
            btn1.text = questionModelList[currentIndex].options[1]
            btn2.text = questionModelList[currentIndex].options[2]
            btn3.text = questionModelList[currentIndex].options[3]
        }
    }

    // Function to start the countdown timer
    private fun startTimer() {
        val totalTimeInMillis = timer.toIntOrNull()?.times(60 * 1000) ?: 0

        object : CountDownTimer(totalTimeInMillis.toLong(), 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                val minutes = seconds / 60
                val remainingSeconds = seconds % 60

                // Update the TextView with formatted time
                binding.timerIndicatorTextview.text =
                    String.format("%02d:%02d", minutes, remainingSeconds)
            }

            override fun onFinish() {
                binding.timerIndicatorTextview.text = "Time's up!"
                finishQuiz()
            }
        }.start()
    }




    private fun setButtonClickListeners() {
        val buttons = listOf(binding.btn0, binding.btn1, binding.btn2, binding.btn3)

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                val correctAnswer = questionModelList[currentIndex].correct
                buttons.forEach { it.isEnabled = false }

                if (button.text.toString() == correctAnswer) {
                    button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.light_green))
                    score++
                    Log.i("Score Of quiz" , "${score.toString()}")
                } else {
                    button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.light_red))
                    buttons.find { it.text.toString() == correctAnswer }?.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.light_green))
                }
            }
        }
    }

    private fun resetButtons() {
        val defaultButtonColor = ContextCompat.getColor(requireContext(), R.color.default_button_color) // Replace with your default button color

        val buttons = listOf(binding.btn0, binding.btn1, binding.btn2, binding.btn3)
        buttons.forEach { button ->
            button.isEnabled = true // Re-enable the button
            button.setBackgroundColor(defaultButtonColor) // Reset to default color
        }
    }

    private fun finishQuiz() {
        val totalQuestions = questionModelList.size
        val percentage = (score.toFloat() / totalQuestions.toFloat() * 100).toInt()

        val dialogBinding = ScoreDialogBinding.inflate(layoutInflater)
        val dialog = androidx.appcompat.app.AlertDialog.Builder(requireContext())
            .setView(dialogBinding.root)
            .create()

        dialogBinding.apply {
            scoreProgressIndicator.progress = percentage
            scoreProgressText.text = "$percentage %"
            scoreProgressTextQs.text = "$score / $totalQuestions correct questions"

            scoreProgressRemark.text = when {
                percentage == 100 -> "Perfect score! You’re a pro at this!"
                percentage >= 80 -> "Awesome performance! A little more effort and you'll perfect this."
                percentage in 60..79 -> "Nice job! Keep up the good work and you’ll excel even more!"
                percentage in 40..59 -> "Not bad! You’re on the right track. Keep practicing and you’ll improve!"
                percentage in 20..39 -> "Needs improvement! Review the concepts and give it another shot."
                else -> "Keep trying! Don’t get discouraged, you’ll get better with practice."
            }

            finishQuiz.setOnClickListener {
                dialog.dismiss()  // Dismiss the dialog
                findNavController().navigate(R.id.action_quizQuesFragment_to_quizTypeFragment)
            }
        }

        dialog.show()  // Show the dialog to the user
    }
    private fun handleBackPress() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
               exitQuiz()
            }
        })
    }


}

