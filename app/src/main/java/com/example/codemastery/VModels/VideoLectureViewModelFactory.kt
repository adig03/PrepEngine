package com.example.codemastery.VModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.codemastery.repositiories.VideoRepository

class VideoLectureViewModelFactory(
    private val repository: VideoRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(VideoLectureViewModels::class.java) -> {
                VideoLectureViewModels(repository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}
