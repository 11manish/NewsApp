package com.mhansda.newsapp.repository


import com.mhansda.newsapp.data.DataOrException
import com.mhansda.newsapp.domain.model.News
import com.mhansda.newsapp.network.NewsApi
import javax.inject.Inject

class NewsRepository @Inject constructor(private val api: NewsApi) {
    private val dataOrException = DataOrException<News,Boolean,Exception>()

    suspend fun getAllNews():DataOrException<News,Boolean,Exception>{
        try{
            dataOrException.isLoading = true
            dataOrException.data = api.getNews()
            if(dataOrException.data.toString().isNotEmpty()) dataOrException.isLoading = false
        }catch (exception:Exception){
            dataOrException.e = exception
        }
        return dataOrException
    }
}