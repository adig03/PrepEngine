package com.example.codemastery.VModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codemastery.Models.QuestionModelItem
import com.example.codemastery.repositiories.MainRepository
import com.example.codemastery.util.Resource
import kotlinx.coroutines.launch

class QuizViewModel(private val repo: MainRepository) : ViewModel() {

    private val _randomQuestions = MutableLiveData<Resource<List<QuestionModelItem>>>()
    val randomQuestions: LiveData<Resource<List<QuestionModelItem>>> get() = _randomQuestions



    init{
        fetchAllRandomQuestions()
    }
    fun fetchAllRandomQuestions() {
        viewModelScope.launch {
            _randomQuestions.postValue(Resource.Loading())
            try {
                val response = repo.getRandomQuestions()
                if (response.isSuccessful) {
                    response.body()?.let { questions ->
                        _randomQuestions.postValue(Resource.Success(questions))
                    } ?: run {
                        _randomQuestions.postValue(Resource.Error("Response body is null"))
                    }
                } else {
                    _randomQuestions.postValue(Resource.Error("Error: ${response.message()}"))
                }
            } catch (e: Exception) {
                _randomQuestions.postValue(Resource.Error("Failed to fetch questions: ${e.message}"))
            }
        }
    }
}
