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
                title = { Text(text = stringResource(id = R.string.first_partial_title), color = Color.White) },
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
                    Text(text = stringResource(id = R.string.time_fire_title))
                }
                Button(onClick = {
                    navController.navigate(Routes.SumView)
                }) {
                    Text(text = stringResource(id = R.string.sum_title))
                }
                Button(onClick = {
                    navController.navigate(Routes.SoccerView)
                }) {
                    Text(text = stringResource(id = R.string.soccer_title))
                }
                Button(onClick = {
                    navController.navigate(Routes.GameView)
                }) {
                    Text(text = stringResource(id = R.string.game_title))
                }
                Button(onClick = {
                    navController.navigate(Routes.ImcView)
                }) {
                    Text(text = stringResource(id = R.string.imc_title))
                }
                Button(onClick = {
                    navController.navigate(Routes.ExamenView)
                }) {
                    Text(text = stringResource(id = R.string.examen_title))
                }
                Button(onClick = {
                    navController.navigate(Routes.GymView)
                }) {
                    Text(text = stringResource(id = R.string.gym_title))
                }
                Button(onClick = {
                    navController.navigate(Routes.RestView)
                }) {
                    Text(text = stringResource(id = R.string.rest_title))
                }
                Button(onClick = {
                    navController.navigate(Routes.LottieAnimationView)
                }) {
                    Text(text = stringResource(id = R.string.lottie_title))
                }
                Button(onClick = {
                    navController.navigate(Routes.spotifyview)
                }) {
                    Text(text = stringResource(id = R.string.spotify_title))
                }
            }
        },
        bottomBar = {
            BottomNavBarView(navController = navController)
    }
    )
        }


