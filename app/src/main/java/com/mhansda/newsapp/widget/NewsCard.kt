package com.mhansda.newsapp.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.mhansda.newsapp.domain.model.Article


@Composable
fun NewsCard(article: Article){
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(370.dp)
        .padding(vertical = 1.dp),
        elevation = 4.dp
    ) {
        Column {
            val painter = rememberAsyncImagePainter(model = article.urlToImage)
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(270.dp),
                )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = article.title,
                style = TextStyle(
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ),
                maxLines = 1,
                modifier = Modifier.padding(horizontal = 6.dp)

            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = article.content,
                style = TextStyle(
                    fontSize = 16.sp,

                ),
                maxLines = 3,
                modifier = Modifier.padding(horizontal = 6.dp)
            )
        }
    }
}