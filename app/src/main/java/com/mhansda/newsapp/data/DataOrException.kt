package com.mhansda.newsapp.data

data class DataOrException<T,Boolean,E:Exception>(
    var data:T ? = null,
    var isLoading:Boolean ? = null,
    var e:Exception ? = null

)
