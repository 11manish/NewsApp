package com.mhansda.newsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.mhansda.newsapp.animation.LoadingNewsListShimmer
import com.mhansda.newsapp.ui.theme.NewsAppTheme
import com.mhansda.newsapp.viewmodel.NewsViewModel
import com.mhansda.newsapp.widget.NewsCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model:NewsViewModel by viewModels()
        setContent {
            NewsAppTheme {
                MainContent(model)
            }
        }
    }
}
@Composable
fun MainContent(viewModel : NewsViewModel){
    val data = viewModel.data.value
    if (data.isLoading == true){
        LoadingNewsListShimmer(imageHeight = 230.dp)
    }else{
        LazyColumn{
            items(items = data.data!!.articles){ article ->
                NewsCard(article = article)
            }
        }
    }
}