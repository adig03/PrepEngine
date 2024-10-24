package com.example.codemastery.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codemastery.pdf.PdfRepository

import kotlinx.coroutines.launch

class PdfViewModel(private val repository: PdfRepository) : ViewModel() {


    private val _pdfUrls = MutableLiveData<List<String>>()
    val pdfUrls: LiveData<List<String>> get() = _pdfUrls
    private val _pdfNames = MutableLiveData<List<String>>()
    val pdfNames: LiveData<List<String>> get() = _pdfUrls


    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error


    fun getPdfs(subject: String) = viewModelScope.launch {
        repository.getAllPdfUrls(subject, { urls ->
            _pdfUrls.postValue(urls)
        }, { exception ->
            _error.postValue(exception.message)
        })
    }

    fun getPdfNames(subject: String) = viewModelScope.launch {
        repository.getPdfNames(subject, { names ->
            _pdfNames.value = names
        }, { exception ->
           _error.postValue(exception.message)
        })
    }



}
