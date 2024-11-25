package com.example.codemastery.VModels

import UserRepo
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.codemastery.repositiories.MainRepository
import com.example.codemastery.viewmodels.AppViewModel


class AppViewModelFactory(private val repo: UserRepo , private val mainRepo:MainRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AppViewModel(repo , mainRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}