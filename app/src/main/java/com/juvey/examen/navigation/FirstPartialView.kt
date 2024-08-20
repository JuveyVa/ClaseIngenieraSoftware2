package com.juvey.examen.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun FirstPartialView(navController: NavController) {
    Column {
        Text(text = "First View")
        Button(onClick = {
            navController.navigate(Routes.TimeFireView)
        }) {
            Text(text = "Go to TimeFireView")
        }
        Button(onClick = {
            navController.navigate(Routes.SumView)
        }) {
            Text(text = "Go to SumView")
        }
        Button(onClick = {
            navController.navigate(Routes.SoccerView)
        }) {
            Text(text = "Go to SoccerView")
        }
        Button(onClick = {
            navController.navigate(Routes.GameView)
        }) {
            Text(text = "Go to GameView")
        }
        Button(onClick = {
            navController.navigate(Routes.ImcView)
        }) {
            Text(text = "Go to ImcView")
        }
        Button(onClick = {
            navController.navigate(Routes.ExamenView)
        }) {
            Text(text = "Go to ExamenView")
        }
        Button(onClick = {
            navController.navigate(Routes.GymView)
        }) {
            Text(text = "Go to GymView")
        }
        Button(onClick = {
            navController.navigate(Routes.RestView)
        }) {
            Text(text = "Go to RestView")
        }
    }
}