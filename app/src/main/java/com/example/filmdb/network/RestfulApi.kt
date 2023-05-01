package com.example.filmdb.network

import com.example.filmdb.model.PopularMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestfulApi {
    @GET("movie/popular?")
    fun getmoviepopular(
        @Query("api_key") APIKEY: String,
        @Query("page") PAGE: Int
    ): Call<PopularMovie<com.example.filmdb.model.Result>>

}