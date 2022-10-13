package com.mhansda.newsapp.viewmodel


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mhansda.newsapp.data.DataOrException
import com.mhansda.newsapp.domain.model.News
import com.mhansda.newsapp.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository):ViewModel()
{
    private val _data:MutableState<DataOrException<News,Boolean,Exception>> =
        mutableStateOf(DataOrException(null,true,Exception(" ")))

    val data = _data

    init {
        getAllNews()
    }
    private fun getAllNews(){
        viewModelScope.launch {
            _data.value.isLoading = true
            _data.value = repository.getAllNews()
            if (_data.value.data.toString().isNotEmpty()){
                _data.value.isLoading = false
            }
        }
    }
}