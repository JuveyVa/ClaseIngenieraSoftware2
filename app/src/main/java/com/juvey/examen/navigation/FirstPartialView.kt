package com.juvey.examen.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.juvey.examen.R
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FirstPartialView(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Primer Parcial", color = Color.White) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Black,
                )
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                Text(text = stringResource(id = R.string.app_name))
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
                Button(onClick = {
                    navController.navigate(Routes.LottieAnimationView)
                }) {
                    Text(text = "Go to LottieAnimationView")
                }
                Button(onClick = {
                    navController.navigate(Routes.spotifyview)
                }) {
                    Text(text = "Go to SpotifyView")
                }
            }
        },
        bottomBar = {
            BottomNavBarView(navController = navController)
    }
    )
        }


