package com.suleymancelik.marvelapp.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelAPI {

    @GET("characters")
    fun fetchAllCharacters(
        @Query("offset") offset: Int? = 0,
        @Query("limit") limit: Int? = 30
    ): Call<CharacterListModel>

}