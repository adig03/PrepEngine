package com.example.codemastery.viewmodels

import UserRepo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codemastery.Models.QuestionModelItem
import com.example.codemastery.Models.QuestionModelX
import com.example.codemastery.Models.SubjectsResponseItem
import com.example.codemastery.repositiories.MainRepository
import com.example.codemastery.user.User
import com.example.codemastery.util.Resource
import kotlinx.coroutines.launch




class AppViewModel(
    private val userRepo: UserRepo,
    private val mainRepo: MainRepository
) : ViewModel() {

    private val _userDetails = MutableLiveData<User?>()
    val userDetails: LiveData<User?> get() = _userDetails

    private val _subjectsState = MutableLiveData<Resource<List<SubjectsResponseItem>>>()
    val subjectsState: LiveData<Resource<List<SubjectsResponseItem>>> get() = _subjectsState



    fun fetchUserDetails() {
        viewModelScope.launch {
            try {
                val user = userRepo.fetchLoggedInUserDetails()
                _userDetails.postValue(user)
            } catch (e: Exception) {
                _subjectsState.postValue(Resource.Error("Failed to fetch user details: ${e.message}"))
            }
        }
    }

    fun fetchAllSubjects() {
        viewModelScope.launch {
            _subjectsState.postValue(Resource.Loading())
            try {
                val response = mainRepo.getAllCategories()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _subjectsState.postValue(Resource.Success(it))
                    } ?: run {
                        _subjectsState.postValue(Resource.Error("Response body is null"))
                    }
                } else {
                    _subjectsState.postValue(Resource.Error("Error: ${response.message()}"))
                }
            } catch (e: Exception) {
                _subjectsState.postValue(Resource.Error("Failed to fetch subjects: ${e.message}"))
            }
        }
    }




    }

