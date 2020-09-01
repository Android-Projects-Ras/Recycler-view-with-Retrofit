package com.rogok.recyclerviewwithretrofit.api

import com.rogok.recyclerviewwithretrofit.model.Post
import com.rogok.recyclerviewwithretrofit.model.user_model.Data
import com.rogok.recyclerviewwithretrofit.model.user_model.User
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost(): Post

    @GET("api/users?page=2")
    suspend fun getUser(): User
}