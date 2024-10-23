package com.example.codemastery.Quizes.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.codemastery.Models.QuestionModel
import com.example.codemastery.Models.QuizModel
import com.example.codemastery.R
import com.example.codemastery.adapters.QuizListAdapter
import com.example.codemastery.databinding.FragmentQuizTypeBinding
import com.example.codemastery.main.MainActivity
import com.google.firebase.database.FirebaseDatabase

class QuizTypeFragment : Fragment(R.layout.fragment_quiz_type) {

    private lateinit var binding: FragmentQuizTypeBinding
    lateinit var quizModelList: MutableList<QuizModel>
    lateinit var adapter: QuizListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz_type, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        quizModelList = mutableListOf()
        getDataFromFirebase()

        // Handle back press
        handleBackPress()
    }

    private fun getDataFromFirebase() {
        val listQuestionModel = mutableListOf<QuestionModel>()

        // Add questions to the list
        listQuestionModel.add(QuestionModel(1, "What is the full form of CPU?", mutableListOf("Central Processing Unit", "Central Program Unit", "Central Power Unit", "Central Processor Unit"), "Central Processing Unit"))
        listQuestionModel.add(QuestionModel(2, "What is the full form of RAM?", mutableListOf("Random Access Memory", "Read Access Memory", "Run Access Memory", "Random Allocated Memory"), "Random Access Memory"))
        listQuestionModel.add(QuestionModel(3, "Which one is a programming language?", mutableListOf("HTML", "CSS", "Python", "SQL"), "Python"))
        listQuestionModel.add(QuestionModel(4, "Which data structure uses LIFO?", mutableListOf("Queue", "Stack", "Array", "Linked List"), "Stack"))
        listQuestionModel.add(QuestionModel(5, "Which of these is not an operating system?", mutableListOf("Windows", "Linux", "Oracle", "MacOS"), "Oracle"))
        listQuestionModel.add(QuestionModel(6, "What does HTTP stand for?", mutableListOf("Hyper Text Transfer Protocol", "Hyper Transfer Text Protocol", "Hyper Time Text Protocol", "Hyper Tool Text Protocol"), "Hyper Text Transfer Protocol"))
        listQuestionModel.add(QuestionModel(7, "Which is the fastest type of memory?", mutableListOf("RAM", "ROM", "Cache", "Hard Disk"), "Cache"))
        listQuestionModel.add(QuestionModel(8, "What is an algorithm?", mutableListOf("A type of data", "A process or set of rules", "A programming language", "A software"), "A process or set of rules"))
        listQuestionModel.add(QuestionModel(9, "Which of the following is a type of software?", mutableListOf("Application", "Hardware", "Firmware", "Protocol"), "Application"))
        listQuestionModel.add(QuestionModel(10, "What is the time complexity of binary search?", mutableListOf("O(n)", "O(log n)", "O(n^2)", "O(1)"), "O(log n)"))
        listQuestionModel.add(QuestionModel(11, "Which of these is a relational database?", mutableListOf("MongoDB", "MySQL", "Cassandra", "Redis"), "MySQL"))
        listQuestionModel.add(QuestionModel(12, "Which programming language is used for Android development?", mutableListOf("Kotlin", "Swift", "JavaScript", "Python"), "Kotlin"))
        listQuestionModel.add(QuestionModel(13, "Which of these is not a data type?", mutableListOf("String", "Float", "Char", "Word"), "Word"))
        listQuestionModel.add(QuestionModel(14, "What does SQL stand for?", mutableListOf("Structured Query Language", "Sequential Query Language", "Simple Query Language", "Statement Query Language"), "Structured Query Language"))
        listQuestionModel.add(QuestionModel(15, "Which layer of the OSI model is responsible for routing?", mutableListOf("Physical Layer", "Data Link Layer", "Network Layer", "Transport Layer"), "Network Layer"))
        listQuestionModel.add(QuestionModel(16, "What is a compiler?", mutableListOf("A device", "A hardware", "A software that converts high-level language to machine code", "A type of memory"), "A software that converts high-level language to machine code"))
        listQuestionModel.add(QuestionModel(17, "Which of these is an example of a NoSQL database?", mutableListOf("Oracle", "SQLite", "PostgreSQL", "MongoDB"), "MongoDB"))
        listQuestionModel.add(QuestionModel(18, "Which sorting algorithm has the best time complexity?", mutableListOf("Quick Sort", "Bubble Sort", "Insertion Sort", "Merge Sort"), "Merge Sort"))
        listQuestionModel.add(QuestionModel(19, "What does IDE stand for in software development?", mutableListOf("Integrated Design Environment", "Integrated Development Environment", "Internet Development Environment", "Independent Design Environment"), "Integrated Development Environment"))
        listQuestionModel.add(QuestionModel(20, "What is the main purpose of DNS?", mutableListOf("To translate domain names to IP addresses", "To block malicious websites", "To manage network security", "To allocate IP addresses"), "To translate domain names to IP addresses"))



        quizModelList.add(QuizModel("Random ", "20 random Questions for CS", "1", listQuestionModel))
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.progressBar.visibility = View.GONE
        adapter = QuizListAdapter(quizModelList)
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = adapter
    }

    private fun handleBackPress() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Pass intent to MainActivity on back press
                val intent = Intent(requireActivity(), MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                startActivity(intent)
                requireActivity().finish() // Optional, if you want to close the fragment's host activity
            }
        })
    }
}
