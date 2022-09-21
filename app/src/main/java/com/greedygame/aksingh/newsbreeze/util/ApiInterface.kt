package com.greedygame.aksingh.newsbreeze.util

import com.greedygame.aksingh.newsbreeze.model.HeadlineResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface
{
    @GET("top-headlines")
    fun getNews(
        @Query("country") country: String?,
        @Query("apiKey") apiKey: String
    ): Call<HeadlineResponse>

    @GET("everything")
    fun searchNews(
        @Query("q") keyword: String?,
        @Query("apiKey") apiKey: String,
        @Query("searchIn") searchIn: String = "title"
    ): Call<HeadlineResponse>
}