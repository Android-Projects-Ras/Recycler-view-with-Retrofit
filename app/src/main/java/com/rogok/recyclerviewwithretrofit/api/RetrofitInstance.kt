package com.rogok.recyclerviewwithretrofit.api

import com.rogok.recyclerviewwithretrofit.util.Constants.Companion.BASE_URL
import com.rogok.recyclerviewwithretrofit.util.Constants.Companion.BASE_URL2
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}