package com.example.jetpack.ui.screen


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun HomeScreen(
    img: Array<Int>,
    name: Array<String>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        LazyColumn(contentPadding = PaddingValues(16.dp)) {
            val item = img.size

            items(item) {
                ColumnItem(
                    modifier,
                    img = img,
                    name = name,
                    index = it,
                    navController = navController
                )
            }
        }

        FloatingActionButton(
            onClick = {
                navController.navigate(route = "ProfileScreen")
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd),
        ) {
            Icon(Icons.Filled.Add, "about_page")
        }
    }
}

@Composable
fun ColumnItem(
    modifier: Modifier,
    img: Array<Int>,
    name: Array<String>,
    index: Int,
    navController: NavController
) {
    Card(
        modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable {
                navController.navigate(route = "DetailScreen/$index")
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AsyncImage(
                model = img[index],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Column(modifier.padding(12.dp)) {
                Text(text = name[index], fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}