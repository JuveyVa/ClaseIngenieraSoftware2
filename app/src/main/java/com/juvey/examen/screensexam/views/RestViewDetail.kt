package com.juvey.examen.screensexam.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.juvey.examen.screensexam.models.Rest


@Composable
fun RestViewDetail(rest: Rest, navController: NavController) {
    Column {
        Text(text = rest.name)
    }

}