package com.example.codemastery.VideoLecture.Fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codemastery.R
import com.example.codemastery.adapters.VideoLectureAdapter
import com.example.codemastery.databinding.FragmentVideolistBinding
import com.example.codemastery.repositiories.VideoRepository
import com.example.codemastery.util.Resource
import com.example.codemastery.VModels.VideoLectureViewModelFactory
import com.example.codemastery.VModels.VideoLectureViewModels

class VideolistFragment : Fragment(R.layout.fragment_videolist) {

    private lateinit var binding: FragmentVideolistBinding
    private lateinit var viewModel: VideoLectureViewModels
    private lateinit var videoLectureAdapter: VideoLectureAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_videolist, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Handle back press
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            requireActivity().finish() // This will finish the activity and return to the previous one
        }

        binding.toolbar.setNavigationOnClickListener {
            // Optionally handle the toolbar back button click
            requireActivity().finish()
        }

        val repository = VideoRepository()
        val factory = VideoLectureViewModelFactory(repository)
        viewModel = viewModels<VideoLectureViewModels> { factory }.value

        setupRecyclerView()
        observeVideoList()
        val subject = arguments?.getString("subject")

        // Fetch playlist videos based on the subject
        fetchVideosBasedOnSubject(subject)
    }

    private fun fetchVideosBasedOnSubject(subject: String?) {
        when (subject) {
            "Computer Networks" -> {
                viewModel.fetchPlaylistVideos("PL3eEXnCBViH-hlNCNwdfV7VrEcTquANGa")
            }
            "Data Structures" -> {
                viewModel.fetchPlaylistVideos("PLBF3763AF2E1C572F")
            }
            "Algorithms" -> {
                viewModel.fetchPlaylistVideos("PL2SOU6wwxB0uP4rJgf5ayhHWgw7akUWSf")
            }
            "Operating System" -> {
                viewModel.fetchPlaylistVideos("PLdo5W4Nhv31a5ucW_S1K3-x6ztBRD-PNa")
            }
            "OOP" -> {
                viewModel.fetchPlaylistVideos("PL9gnSGHSqcno1G3XjUbwzXHL8_EttOuKk")
            }
            "Databases" -> {
                viewModel.fetchPlaylistVideos("PLBlnK6fEyqRi_CUQ-FXxgzKQ1dwr_ZJWZ")
            }
            "Mathematics for CS" -> {
                viewModel.fetchPlaylistVideos("PLB7540DEDD482705B")
            }
            "Git Fundamentals" -> {
                viewModel.fetchPlaylistVideos("PL-osiE80TeTuRUfjRe54Eea17-YfnOOAx")
            }
            "Security Basics" -> {
                viewModel.fetchPlaylistVideos("PL-JvKqQx2AteIbm-z4X709scVr9OaHpIY")
            }
            "Programming Paradigms" -> {
                viewModel.fetchPlaylistVideos("PL9D558D49CA734A02")
            }
            else -> {
                // Handle case where the subject is not recognized
                Log.e("VideoListFragment", "Subject not recognized: $subject")
            }
        }
    }

    private fun observeVideoList() {
        viewModel.videoList.observe(viewLifecycleOwner, Observer { resource ->
            when (resource) {
                is Resource.Success -> {
                    binding.loadingVideoList.visibility = View.GONE
                    resource.data?.let { videos ->
                        videoLectureAdapter.differ.submitList(videos)
                    }
                }
                is Resource.Error -> {
                    binding.loadingVideoList.visibility = View.GONE
                    // Show error message to the user
                    Toast.makeText(requireContext(), resource.message ?: "An error occurred", Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                    binding.loadingVideoList.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun setupRecyclerView() {
        videoLectureAdapter = VideoLectureAdapter()
        binding.rvVideos.apply {
            adapter = videoLectureAdapter
            layoutManager = LinearLayoutManager(requireActivity())
        }
    }
}
