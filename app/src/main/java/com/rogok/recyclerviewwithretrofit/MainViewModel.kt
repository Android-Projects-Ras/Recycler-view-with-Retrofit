package com.rogok.recyclerviewwithretrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rogok.recyclerviewwithretrofit.model.Post
import com.rogok.recyclerviewwithretrofit.model.user_model.Data
import com.rogok.recyclerviewwithretrofit.model.user_model.User
import com.rogok.recyclerviewwithretrofit.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {
    val myResponse: MutableLiveData<Post> = MutableLiveData()
    val myResponse3: MutableLiveData<User> = MutableLiveData()


    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }


    fun getUser() {
        viewModelScope.launch {
            val response3 = repository.getUser()
            myResponse3.value = response3

        }
    }
}