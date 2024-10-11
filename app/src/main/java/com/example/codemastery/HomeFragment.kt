package com.example.codemastery

import UserRepo
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.example.codemastery.Models.GridItem
import com.example.codemastery.Models.RecyclerItem
import com.example.codemastery.adapters.MyGridAdapter
import com.example.codemastery.adapters.MyRecyclerAdapter
import com.example.codemastery.databinding.FragmentHomeBinding

import com.example.codemastery.user.User
import com.example.codemastery.viewModels.AppViewModel
import com.example.codemastery.viewModels.AppViewModelFactory
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch


class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var appViewModel: AppViewModel
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
        val userName = "Aditya Gupta"

        animateText(mainUserName, userName)

        displayGrid(view)

        displayRecyclerView(view)

        val userRepo = UserRepo()
        val viewModelFactory = AppViewModelFactory(userRepo)

        appViewModel = ViewModelProvider(this, viewModelFactory)[AppViewModel::class.java]







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

    private fun displayRecyclerView(view: View) {
        val cardsRecyclerView: RecyclerView = view.findViewById(R.id.MyRecylerView)
        val gridLayoutManager = GridLayoutManager(requireContext(), 1,GridLayoutManager.VERTICAL, false)
        cardsRecyclerView.layoutManager = gridLayoutManager

        val lowerGrid = arrayListOf(
            RecyclerItem("Data Structures", "9 Topics", R.drawable.datastructures),
            RecyclerItem("Algorithms", "8 Topics", R.drawable.algorithem),
            RecyclerItem("OOP", "3 Topics", R.drawable.oops),
            RecyclerItem("Operating System", "5 Topics", R.drawable.operatingsystems),
            RecyclerItem("Databases", "6 Topics", R.drawable.databases),
            RecyclerItem("Computer Networks", "5 Topics", R.drawable.computernetwork),
            RecyclerItem("Mathematics For CS", "5 Topics", R.drawable.mathsforcs),
            RecyclerItem("Programming Paradigms", "5 Topics", R.drawable.programmingpara),
            RecyclerItem("Git Fundamentals", "X Topics", R.drawable.git),
            RecyclerItem("Security Basics", "3 Topics", R.drawable.securitybasis),

            )


        val  lowerGridAdapter = MyRecyclerAdapter(lowerGrid)
        cardsRecyclerView.adapter = lowerGridAdapter

    }
}


