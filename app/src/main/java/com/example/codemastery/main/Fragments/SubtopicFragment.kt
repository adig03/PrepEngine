package com.example.codemastery.main.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codemastery.Models.RecyclerItem
import com.example.codemastery.Models.SubTopicGridItem
import com.example.codemastery.R
import com.example.codemastery.adapters.TopicRVAdapter
import com.example.codemastery.adapters.TopicsGridAdapters
import com.example.codemastery.databinding.FragmentSubtopicBinding

class SubtopicFragment : Fragment() {

    private lateinit var binding: FragmentSubtopicBinding
    private lateinit var topicRVAdapter: TopicRVAdapter
    private lateinit var gridAdapter: TopicsGridAdapters

    val args: SubtopicFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_subtopic, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayGrid()

        val subjectName = args.subjectTitle.toString()
        binding.toolbar2.title = subjectName
        when (subjectName) {
            "Data Structures" -> displayDataStructuresTopics()
            "OOP" -> displayOOPTopics()
            "Algorithms" -> displayAlgorithmTopics()
            "Operating System" -> displayOperatingSystemTopics()
            "Databases" -> displayDatabasesTopics()
            "Computer Networks" -> displayComputerNetworkTopics()
            "Mathematics For CS" -> displayMathTopics()
            "Programming Paradigms" -> displayParadigmsTopics()
            "Git Fundamentals" -> displayGitTopics()
            "Security Basics" -> displaySecurityTopics()
        }

        binding.toolbar2.setNavigationOnClickListener{
            findNavController().navigate(R.id.action_subtopicFragment_to_homeFragment)
        }
    }

    private fun displayAlgorithmTopics() {
        val allTopicListItem = arrayListOf(
            RecyclerItem("Sorting Algorithms", "X Questions", R.drawable.sorting),
            RecyclerItem("Searching Algorithms", "Y Questions", R.drawable.searching),
            RecyclerItem("Graph Algorithms", "Z Questions", R.drawable.graph_algorithems),
            RecyclerItem("Dynamic Programming", "W Questions", R.drawable.dp)
        )
        setupRecyclerView(allTopicListItem)
    }

    private fun displaySecurityTopics() {
        val allTopicListItem = arrayListOf(
            RecyclerItem("Encryption", "X Questions", R.drawable.encryption),
            RecyclerItem("Authentication", "Y Questions", R.drawable.authentication),
            RecyclerItem("Network Security", "Z Questions", R.drawable.network_security),
            RecyclerItem("Cryptography", "W Questions", R.drawable.cryptography)
        )
        setupRecyclerView(allTopicListItem)
    }

    private fun displayGitTopics() {
        val allTopicListItem = arrayListOf(
            RecyclerItem("Git Basics", "X Questions", R.drawable.git_basics),
            RecyclerItem("Branches", "Y Questions", R.drawable.branches),
            RecyclerItem("Merge Conflicts", "Z Questions", R.drawable.merge_conflicts),
            RecyclerItem("Rebasing", "W Questions", R.drawable.rebasing)
        )
        setupRecyclerView(allTopicListItem)
    }

    private fun displayParadigmsTopics() {
        val allTopicListItem = arrayListOf(
            RecyclerItem("Functional Programming", "X Questions", R.drawable.functional_programming),
            RecyclerItem("Object-Oriented Programming", "Y Questions", R.drawable.oop),
            RecyclerItem("Imperative vs Declarative", "Z Questions", R.drawable.imperative),
            RecyclerItem("Event-driven Programming", "W Questions", R.drawable.event_driven)
        )
        setupRecyclerView(allTopicListItem)
    }

    private fun displayMathTopics() {
        val allTopicListItem = arrayListOf(
            RecyclerItem("Discrete Math", "X Questions", R.drawable.discret_mathematics),
            RecyclerItem("Probability", "Y Questions", R.drawable.probablity),
            RecyclerItem("Number Theory" , "Y Questions" , R.drawable.number_theory),
            RecyclerItem("Graph Theory" , "Z Questions" , R.drawable.graph_theory),
            RecyclerItem("Modular Arithematic" , "M Questions" , R.drawable.modular_arithematic),
            RecyclerItem("Statistics", "Z Questions", R.drawable.statistics),
            RecyclerItem("Linear Algebra", "W Questions", R.drawable.linear_algebra)
        )
        setupRecyclerView(allTopicListItem)
    }

    private fun displayDatabasesTopics() {
        val allTopicListItem = arrayListOf(
            RecyclerItem("SQL Basics", "X Questions", R.drawable.sql_basics),
            RecyclerItem("Normalization", "Y Questions", R.drawable.normalization),
            RecyclerItem("Indexing" , "M Questions" , R.drawable.indexing),
            RecyclerItem("ACID Properties", "Z Questions", R.drawable.acid),
            RecyclerItem("NoSQL Databases" , "W Questions" , R.drawable.nosqldatabases),
            RecyclerItem("Joins", "W Questions", R.drawable.joins)
        )
        setupRecyclerView(allTopicListItem)
    }

    private fun displayOperatingSystemTopics() {
        val allTopicListItem = arrayListOf(
            RecyclerItem("Process Management", "X Questions", R.drawable.process_management),
            RecyclerItem("Concurrency and Synchronisation", "X Questions", R.drawable.concurrency),
            RecyclerItem("Memory Management", "Y Questions", R.drawable.memory_management),
            RecyclerItem("File Systems", "Z Questions", R.drawable.file_system),
            RecyclerItem("CPU Scheduling Algorithems", "W Questions", R.drawable.cpu_scheduling)
        )
        setupRecyclerView(allTopicListItem)
    }

    private fun displayOOPTopics() {
        val allTopicListItem = arrayListOf(
            RecyclerItem("Classes and Objects", "X Questions", R.drawable.classes_objects),
            RecyclerItem("Inheritance", "Y Questions", R.drawable.inheritance),
            RecyclerItem("Polymorphism", "Z Questions", R.drawable.polumorphism),
            RecyclerItem("Abstraction", "W Questions", R.drawable.abstraction)
        )
        setupRecyclerView(allTopicListItem)
    }

    private fun displayDataStructuresTopics() {
        val allTopicListItem = arrayListOf(
            RecyclerItem("Arrays", "X Questions", R.drawable.array),
            RecyclerItem("Linked Lists", "Y Questions", R.drawable.linklist),
            RecyclerItem("Stacks", "Z Questions", R.drawable.stacks),
            RecyclerItem("Hash Table", "W Questions", R.drawable.hashtable),
            RecyclerItem("Heaps", "Q Questions", R.drawable.heap),
            RecyclerItem("Trees", "S Questions", R.drawable.binarytree),
            RecyclerItem("Graphs", "E Questions", R.drawable.graph)
        )
        setupRecyclerView(allTopicListItem)
    }

    private fun displayComputerNetworkTopics() {
        val allTopicListItem = arrayListOf(
            RecyclerItem("OSI Model", "X Questions", R.drawable.osi_model),
            RecyclerItem("TCP/IP Model", "Y Questions", R.drawable.tcp_ip),
            RecyclerItem("Routing Algorithms", "Z Questions", R.drawable.routing),
            RecyclerItem("IP Addressing", "W Questions", R.drawable.ip_addressing),
            RecyclerItem("Network Layers", "Q Questions", R.drawable.network_layers)
        )
        setupRecyclerView(allTopicListItem)
    }

    private fun setupRecyclerView(items: List<RecyclerItem>) {
        topicRVAdapter = TopicRVAdapter(items)
        binding.topicRv.layoutManager = LinearLayoutManager(requireContext())
        binding.topicRv.adapter = topicRVAdapter
    }

    private fun displayGrid() {
        val allGridItems = arrayListOf(
            SubTopicGridItem(R.drawable.stickynotes, "Notes"),
            SubTopicGridItem(R.drawable.testpapers, "Test Papers"),
            SubTopicGridItem(R.drawable.videolectures, "Video Lectures"),
            SubTopicGridItem(R.drawable.flashcard, "Flash Cards")
        )

        gridAdapter = TopicsGridAdapters(requireContext(), allGridItems , args.subjectTitle)
        binding.topicGrid.adapter = gridAdapter
    }
}
