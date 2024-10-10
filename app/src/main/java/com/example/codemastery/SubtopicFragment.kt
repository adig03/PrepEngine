package com.example.codemastery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codemastery.Models.RecyclerItem
import com.example.codemastery.Models.SubTopicGridItem
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
        binding.toolbar2.setTitle(subjectName)
        when (subjectName) {
            "Computer Network" -> {
//                displayComputerNetworkTopics()
            }
            "Data Structures" -> {
                displayDataStructuresTopics()
            }
        }
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

        topicRVAdapter = TopicRVAdapter(allTopicListItem)

        // Setting LayoutManager to ensure proper display
        binding.topicRv.layoutManager = LinearLayoutManager(requireContext())
        binding.topicRv.adapter = topicRVAdapter
    }

//    private fun displayComputerNetworkTopics() {
//        val allTopicListItem = arrayListOf(
//            RecyclerItem("OSI Model", "X Questions", R.drawable.osi_model),
//            RecyclerItem("TCP/IP Model", "Y Questions", R.drawable.tcp_ip),
//            RecyclerItem("Routing Algorithms", "Z Questions", R.drawable.routing),
//            RecyclerItem("IP Addressing", "W Questions", R.drawable.ip_addressing),
//            RecyclerItem("Network Layers", "Q Questions", R.drawable.network_layers)
//        )

//        topicRVAdapter = TopicRVAdapter(allTopicListItem)
//
//        binding.topicRv.layoutManager = LinearLayoutManager(requireContext())
//        binding.topicRv.adapter = topicRVAdapter
//    }

    private fun displayGrid() {
        val allGridItems = arrayListOf(
            SubTopicGridItem(R.drawable.stickynotes, "Notes"),
            SubTopicGridItem(R.drawable.testpapers, "Test Papers"),
            SubTopicGridItem(R.drawable.videolectures, "Video Lectures"),
            SubTopicGridItem(R.drawable.flashcard, "Flash Cards")
        )

        gridAdapter = TopicsGridAdapters(requireContext(), allGridItems)
        binding.topicGrid.adapter = gridAdapter
    }
}
