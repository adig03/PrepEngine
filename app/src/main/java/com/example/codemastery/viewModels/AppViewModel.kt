package com.example.codemastery.viewModels

import UserRepo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.codemastery.user.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AppViewModel(private val repo: UserRepo) : ViewModel() {




    private val _userDetails = MutableLiveData<User?>()
    val userDetails: LiveData<User?> get() = _userDetails


    fun fetchUserDetails() {
        viewModelScope.launch {

            val user = repo.fetchLoggedInUserDetails()

            _userDetails.postValue(user)
        }
    }
}
