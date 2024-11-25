package com.example.codemastery.Quizes.Fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codemastery.Models.QuestionModelItem
import com.example.codemastery.Models.QuizModel
import com.example.codemastery.R
import com.example.codemastery.VModels.QuizViewModel
import com.example.codemastery.VModels.QuizViewModelFactory
import com.example.codemastery.adapters.QuizListAdapter
import com.example.codemastery.databinding.FragmentQuizTypeBinding
import com.example.codemastery.main.MainActivity
import com.example.codemastery.repositiories.MainRepository
import com.example.codemastery.util.Resource

class QuizTypeFragment : Fragment(R.layout.fragment_quiz_type) {

    private lateinit var binding: FragmentQuizTypeBinding
    private lateinit var quizModelList: MutableList<QuizModel>
    private lateinit var adapter: QuizListAdapter
    private lateinit var quizViewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz_type, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the quiz list and adapter
        quizModelList = mutableListOf()
        adapter = QuizListAdapter(quizModelList)

        // Initialize ViewModel
        val repository = MainRepository()
        val viewModelFactory = QuizViewModelFactory(repository)
        quizViewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(QuizViewModel::class.java)




        // Fetch data from backend
        getDataFromPrepEngineBackend()

        // Handle back press
        handleBackPress()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getDataFromPrepEngineBackend() {
        quizViewModel.randomQuestions.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resource.Success -> {
                    val questions = resource.data
                    questions?.let { listQuestionModel ->
                        // Clear existing data and update the quiz list
                        quizModelList.clear()
                        quizModelList.add(
                            QuizModel(
                                "Random Questions",
                                "25 random Questions",
                               3,
                                listQuestionModel.toMutableList()
                            )
                        )

                        // Notify adapter of data changes
                        adapter.notifyDataSetChanged()
                        setupRecyclerView()
                        // Hide the progress bar
                        binding.progressBar.visibility = View.GONE

                        Log.d("QuizTypeFragment", "Quiz data loaded successfully: $quizModelList")
                    }
                }

                is Resource.Error -> {
                    // Hide progress bar and show error message
                    binding.progressBar.visibility = View.GONE
                    val errorMessage = resource.message ?: "An error occurred."
                    Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                    Log.e("QuizTypeFragment", "Error loading data: $errorMessage")
                }

                is Resource.Loading -> {
                    // Show progress bar while loading data
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun setupRecyclerView() {
        // Set up the RecyclerView with the adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    private fun handleBackPress() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Navigate back to the MainActivity
                val intent = Intent(requireActivity(), MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                startActivity(intent)
                requireActivity().finish()
            }
        })
    }
}
