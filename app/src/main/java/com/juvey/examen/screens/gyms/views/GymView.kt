package com.juvey.examen.screens.gyms.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import com.juvey.examen.screens.gyms.viewmodel.GymViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue


@Composable
fun GymView(viewModel: GymViewModel) {
    val gyms by viewModel.gyms.collectAsState()
    LazyColumn {
        items(gyms) {
                gym ->
            Text(text = gym.name)
        }
    }
    DisposableEffect(Unit) {
        viewModel.getGyms()
        onDispose {}
    }
}