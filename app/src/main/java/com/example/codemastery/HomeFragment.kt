package com.example.codemastery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codemastery.Models.GridItem
import com.example.codemastery.Models.RecyclerItem
import com.example.codemastery.adapters.MyGridAdapter
import com.example.codemastery.adapters.MyRecyclerAdapter
import com.example.codemastery.databinding.FragmentHomeBinding
import com.google.firebase.firestore.FirebaseFirestore


class HomeFragment : Fragment(R.layout.fragment_home) {
  private lateinit var binding:FragmentHomeBinding
  private lateinit var firestore: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

     displayGrid(view)

        displayRecyclerView(view)


binding.profileImage.setOnClickListener{
    findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
}
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
            RecyclerItem("Algorithems", "8 Topics", R.drawable.algorithem),
            RecyclerItem("OOP", "3 Topics", R.drawable.oops),
            RecyclerItem("Operating System", "5 Topics", R.drawable.operatingsystems),
            RecyclerItem("Databases", "6 Topics", R.drawable.databases),
            RecyclerItem("Computer Networks", "5 Topics", R.drawable.computernetwork),
            RecyclerItem("Mathematics For CS", "5 Topics", R.drawable.mathsforcs),
            RecyclerItem("Programming Paradigms", "5 Topics", R.drawable.programmingpara),
            RecyclerItem("Git Fundamentals", "X Topics", R.drawable.git),
            RecyclerItem("Security Basis", "3 Topics", R.drawable.securitybasis),

            )


        val  lowerGridAdapter = MyRecyclerAdapter(lowerGrid)
        cardsRecyclerView.adapter = lowerGridAdapter

    }
}