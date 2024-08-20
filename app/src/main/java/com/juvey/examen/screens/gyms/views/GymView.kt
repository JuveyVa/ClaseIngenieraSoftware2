package com.juvey.examen.screens.gyms.views

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import com.juvey.examen.screens.gyms.viewmodel.GymViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage

import coil.compose.rememberImagePainter


@Composable
fun GymView(viewModel: GymViewModel, navController: NavController) {
    val gyms by viewModel.gyms.collectAsState()


    LazyColumn {
        items(gyms) {
                gym ->
            Text(text = gym.name)
            AsyncImage(
                model = gym.imageURL,
                contentDescription = "No jala",  modifier = Modifier
                    .size(150.dp)
            )
            Text(text = gym.latitude)
            Text(text = gym.longitude)
        }
    }
    DisposableEffect(Unit) {
        viewModel.getGyms()
        onDispose {}
    }
}