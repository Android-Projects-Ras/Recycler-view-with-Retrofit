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
    val myResponse2: MutableLiveData<Response<List<User>>> = MutableLiveData()
    val myResponse3: MutableLiveData<User> = MutableLiveData()
    val myResponse4: MutableLiveData<Data> = MutableLiveData()


    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response

        }
    }

    fun getUsers() {
        viewModelScope.launch {
            val response2 = repository.getUsers()
            myResponse2.value = response2

        }
    }

    fun getUser() {
        viewModelScope.launch {
            val response3 = repository.getUser()
            myResponse3.value = response3

        }
    }

    fun getData() {
        viewModelScope.launch {
            val response4 = repository.getData()
            myResponse4.value = response4

        }
    }
}