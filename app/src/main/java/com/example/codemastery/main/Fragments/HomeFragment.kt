package com.example.codemastery.main.Fragments


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codemastery.Models.GridItem
import com.example.codemastery.Models.RecyclerItem
import com.example.codemastery.R
import com.example.codemastery.adapters.MyGridAdapter
import com.example.codemastery.adapters.MyRecyclerAdapter
import com.example.codemastery.databinding.FragmentHomeBinding
import com.example.codemastery.viewModels.AppViewModel



class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainUserName = binding.mainUserName


        val sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", 0)
        val userName = sharedPreferences.getString("username", "Guest") // "Guest" is the default value if not found




        if (userName != null) {
            animateText(mainUserName, userName)
        }

        displayGrid(view)

        displayRecyclerView()


        binding.circularView.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }



}

    private fun animateText(textView: TextView, text: String, delay: Long = 150) {
        textView.text = "" // Clear the text initially
        val handler = Handler(Looper.getMainLooper())
        var charIndex = 0

        val runnable = object : Runnable {
            override fun run() {
                if (charIndex < text.length) {
                    textView.text = textView.text.toString() + text[charIndex]
                    charIndex++
                    handler.postDelayed(this, delay) // Post the next character
                }
            }
        }

        handler.post(runnable) // Start the animation
    }


    private fun displayGrid(view: View) {
        val grid: GridView = view.findViewById<GridView>(R.id.GridView)

        val allGridItems = arrayListOf(
            GridItem("Notes", R.drawable.notes),
            GridItem("Quizes", R.drawable.quiz),
            GridItem("Marked Questions", R.drawable.markesques),
            GridItem("Progress", R.drawable.progress)
        )

        val myAdapter = MyGridAdapter(requireContext(), allGridItems)
        grid.adapter = myAdapter
    }

    private fun displayRecyclerView() {
        val cardsRecyclerView: RecyclerView = binding.MyRecylerView
        val gridLayoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.VERTICAL, false)
        cardsRecyclerView.layoutManager = gridLayoutManager

        // Disable nested scrolling for RecyclerView
        cardsRecyclerView.isNestedScrollingEnabled = false

        val lowerGrid = arrayListOf(
            RecyclerItem("Data Structures", "7 Topics", R.drawable.datastructures),
            RecyclerItem("Algorithms", "4 Topics", R.drawable.algorithem),
            RecyclerItem("OOP", "4 Topics", R.drawable.oops),
            RecyclerItem("Operating System", "5 Topics", R.drawable.operatingsystems),
            RecyclerItem("Databases", "6 Topics", R.drawable.databases),
            RecyclerItem("Computer Networks", "5 Topics", R.drawable.computernetwork),
            RecyclerItem("Mathematics For CS", "7 Topics", R.drawable.mathsforcs),
            RecyclerItem("Programming Paradigms", "4 Topics", R.drawable.programmingpara),
            RecyclerItem("Git Fundamentals", "4 Topics", R.drawable.git),
            RecyclerItem("Security Basics", "4 Topics", R.drawable.securitybasis),
        )

        val lowerGridAdapter = MyRecyclerAdapter(lowerGrid)
        cardsRecyclerView.adapter = lowerGridAdapter
    }
}


