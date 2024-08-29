package com.juvey.examen.animation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.LottieAnimationView
import com.juvey.examen.utils.AnimatedPreloader

@Composable
fun LottieAnimationView(navController: NavController){
    Box {
        AnimatedPreloader(modifier = Modifier.size(200.dp).align(Alignment.Center))
    }
}