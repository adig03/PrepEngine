package com.example.codemastery.main.fragments

import UserRepo
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.TextView

import androidx.fragment.app.Fragment

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.LinearLayoutManager

import com.example.codemastery.R
import com.example.codemastery.adapters.MyGridAdapter
import com.example.codemastery.adapters.MyRecyclerAdapter
import com.example.codemastery.databinding.FragmentHomeBinding
import com.example.codemastery.Models.GridItem


import com.example.codemastery.repositiories.MainRepository

import com.example.codemastery.util.Resource
import com.example.codemastery.VModels.AppViewModelFactory

import com.example.codemastery.viewmodels.AppViewModel


class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var appViewModel: AppViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Shared Preferences for username
        val sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", 0)
        val userName = sharedPreferences.getString("username", "Guest") // Default is "Guest"

        // Initialize ViewModel
        val factory = AppViewModelFactory(UserRepo(), MainRepository())
        appViewModel = ViewModelProvider(this, factory)[AppViewModel::class.java]

        // Animate username
        userName?.let { animateText(binding.mainUserName, it) }


        displayGrid()

setupRecyclerView()

        appViewModel.fetchAllSubjects()

        // Circular view navigation to ProfileFragment
        binding.circularView.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }
    }

    private fun setupRecyclerView() {
        // Assuming subjectsState is a LiveData<Resource<List<SubjectsResponseItem>>>
        appViewModel.subjectsState.observe(viewLifecycleOwner, { resource ->
            when (resource) {
                is Resource.Loading -> {
                    // Show loading indicator (e.g., a ProgressBar)
                    showLoading(true)
                }
                is Resource.Success -> {
                    // Hide loading indicator and set the data to the RecyclerView
                    showLoading(false)
                    resource.data?.let { subjectsList ->

                        val subjectAdapter = MyRecyclerAdapter()
                        subjectAdapter.differ.submitList(subjectsList)
                        binding.MyRecylerView.adapter = subjectAdapter
                        binding.MyRecylerView.layoutManager = LinearLayoutManager(activity)
                        binding.MyRecylerView.visibility = View.VISIBLE

                    }
                }
                is Resource.Error -> {
                    // Hide loading indicator and show error message
                    showLoading(false)
                    resource.message?.let { errorMessage ->
//                        showError(errorMessage)
                    }
                }
            }
        })
    }

    private fun showLoading(isLoading: Boolean) {
        // You can show or hide the ProgressBar here
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

//    private fun showError(message: String) {
//        // You can display the error message in a TextView or Snackbar
//        errorTextView.text = message
//        errorTextView.visibility = View.VISIBLE
//    }


    private fun animateText(textView: TextView, text: String, delay: Long = 150) {
        textView.text = ""
        val handler = Handler(Looper.getMainLooper())
        var charIndex = 0
        val runnable = object : Runnable {
            override fun run() {
                if (charIndex < text.length) {
                    textView.text = textView.text.toString() + text[charIndex]
                    charIndex++
                    handler.postDelayed(this, delay)
                }
            }
        }
        handler.post(runnable)
    }

    private fun displayGrid() {
        val gridItems = arrayListOf(
            GridItem("e-Books", R.drawable.notes),
            GridItem("Quizzes", R.drawable.quiz),
            GridItem("Marked Questions", R.drawable.markesques),
            GridItem("Progress", R.drawable.progress)
        )
        val gridView: GridView = binding.GridView
        val gridAdapter = MyGridAdapter(requireContext(), gridItems)
        gridView.adapter = gridAdapter
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
