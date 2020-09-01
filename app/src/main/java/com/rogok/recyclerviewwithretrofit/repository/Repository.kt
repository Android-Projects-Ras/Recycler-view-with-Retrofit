package com.rogok.recyclerviewwithretrofit.repository

import com.rogok.recyclerviewwithretrofit.api.RetrofitInstance
import com.rogok.recyclerviewwithretrofit.model.Post
import com.rogok.recyclerviewwithretrofit.model.user_model.Data
import com.rogok.recyclerviewwithretrofit.model.user_model.User
import retrofit2.Response

class Repository {

    suspend fun getPost(): Post {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getUser(): User {
        return RetrofitInstance.api.getUser()
    }


}