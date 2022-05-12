package com.github.harrypottercharacters.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: HPApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://hp-api.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HPApi::class.java)
    }
}