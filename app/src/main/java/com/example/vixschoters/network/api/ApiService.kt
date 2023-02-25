package com.example.vixschoters.network.api

import com.example.vixschoters.network.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/top-headlines")
    fun getNews(
        @Query("country") country: String,
        @Query("category") category: String?,
        @Query("apiKey") key: String
    ): Call<NewsResponse>
}