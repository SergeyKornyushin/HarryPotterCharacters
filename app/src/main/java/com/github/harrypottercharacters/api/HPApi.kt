package com.github.harrypottercharacters.api

import retrofit2.Response
import retrofit2.http.GET

interface HPApi {

    @GET("/api/characters")
    suspend fun getCharacter() : Response<List<HPCharacter>>
}