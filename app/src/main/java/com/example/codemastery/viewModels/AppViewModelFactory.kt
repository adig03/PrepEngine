package com.example.codemastery.viewModels

import UserRepo
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class AppViewModelFactory(private val repo: UserRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AppViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}