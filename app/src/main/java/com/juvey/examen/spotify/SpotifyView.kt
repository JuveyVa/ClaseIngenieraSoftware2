package com.juvey.examen.spotify

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.juvey.examen.R
import com.juvey.examen.utils.ExoplayerExample

@Composable
fun SpotifyView(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        ExoplayerExample()
        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.TopCenter), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.spotifylogo), contentDescription = "No jala", modifier = Modifier
                .size(250.dp))
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomEnd)) {
            Row {
                Button(onClick = { /*TODO*/ },
                    Modifier
                        .weight(1f)
                        .fillMaxWidth(), colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray), shape = RectangleShape) {
                 Text(text = "LOG IN", color = Color.White, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
                }
                Button(onClick = { /*TODO*/ },
                    Modifier
                        .weight(1f)
                        .fillMaxWidth(), colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green), shape = RectangleShape) {
                    Text(text = "SIGN UP", color = Color.White, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
                }

            }
            Spacer(modifier = Modifier.size(30.dp))
        }
    }
}
