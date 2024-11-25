package com.example.codemastery.VModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.codemastery.repositiories.MainRepository

class QuizViewModelFactory(private val repo: MainRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return QuizViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
