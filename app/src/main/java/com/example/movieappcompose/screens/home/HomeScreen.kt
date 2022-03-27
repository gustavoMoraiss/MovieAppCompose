package com.example.movieappcompose.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieappcompose.model.Movie
import com.example.movieappcompose.model.getMovies
import com.example.movieappcompose.navigation.MovieScreens
import com.example.movieappcompose.widgets.MoviewRow

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.Transparent, elevation = 0.dp) {
                Text(
                    "Movies",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.h4
                )
            }
        },
    ) {
        MainContent(navController = navController)
    }
}


@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movieList) {
                MoviewRow(movie = it) { movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movie")
                }
            }
        }
    }
}