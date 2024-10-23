package com.example.codemastery.Questions.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.codemastery.Models.QModel
import com.example.codemastery.Models.QuestionModel
import com.example.codemastery.Quizes.Fragments.QuizQuesFragment.Companion.questionModelList
import com.example.codemastery.R
import com.example.codemastery.databinding.FragmentQuestionViewBinding


class QuestionViewFragment : Fragment(R.layout.fragment_question_view) {

    private lateinit var binding: FragmentQuestionViewBinding

    companion object {
        var questionList: List<QModel> = listOf()
        var currentIndex = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question_view, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarQ.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        updateQuestion()

        binding.nextqBtn.setOnClickListener {
            if (currentIndex < questionList.size - 1) {
                currentIndex++
                updateQuestion()
                resetButtons()
            }
            else if(currentIndex == questionList.size -1){
                currentIndex = currentIndex + 1
                updateQuestion()
            }
        }

        binding.prevqBtn.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                updateQuestion()
                resetButtons()
            }
        }
        setButtonClickListeners()
    }

    private fun updateQuestion() {
        binding.prevqBtn.visibility = if (currentIndex == 1) View.GONE else View.VISIBLE
        binding.nextqBtn.visibility = if (currentIndex == questionList.size ) View.GONE else View.VISIBLE

        binding.toolbarQ.title = "Question ${currentIndex}/${questionList.size}"
        val currentQuestion = questionList[currentIndex-1]
        binding.questionqTextview.text = currentQuestion.Question
        binding.qbtn0.text = currentQuestion.Options[0]
        binding.qbtn1.text = currentQuestion.Options[1]
        binding.qbtn2.text = currentQuestion.Options[2]
        binding.qbtn3.text = currentQuestion.Options[3]
    }

    private fun setButtonClickListeners() {
        val buttons = listOf(binding.qbtn0, binding.qbtn1, binding.qbtn2, binding.qbtn3)

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
val correctIndex = questionList[currentIndex].Correct
                if (index+1 == correctIndex ) {
                    button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.light_green))

                } else {
                    button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.light_red))
                }
            }
        }


    }
    private fun resetButtons() {
        val defaultButtonColor = ContextCompat.getColor(requireContext(), R.color.light_blue)

        val buttons = listOf(binding.qbtn0, binding.qbtn1, binding.qbtn2, binding.qbtn3)
        buttons.forEach { button ->
            button.setBackgroundColor(defaultButtonColor)
        }
    }

}


