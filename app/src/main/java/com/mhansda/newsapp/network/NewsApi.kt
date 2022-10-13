package com.mhansda.newsapp.network

import com.mhansda.newsapp.domain.model.News
import retrofit2.http.GET
import retrofit2.http.Headers

interface NewsApi {

    @Headers("User-Agent:Mozilla/5.0")
    @GET("/v2/top-headlines?country=us&category=business&apiKey=15e980c21135425481ab6cb96f8db420")
    suspend fun getNews():News
}