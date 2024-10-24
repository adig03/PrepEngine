package com.example.codemastery.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.codemastery.pdf.PdfRepository

class PdfViewModelFactory(private val repo: PdfRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PdfViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PdfViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}