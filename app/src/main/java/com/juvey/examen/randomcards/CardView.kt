package com.juvey.examen.randomcards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.juvey.examen.R

@Composable
fun CardView(viewModel: CardViewModel, navController: NavController) {
    val imagenRandom by viewModel.getRandomImage().observeAsState(R.drawable.back)

    Box(Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
        Column(horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = imagenRandom),
                contentDescription = "No jala",
                modifier = Modifier
                    .size(450.dp)
            )
            Spacer(modifier = Modifier.size(30.dp))
            Row {
                Button(onClick = { viewModel.getRandomElement() },Modifier.weight(1f), shape = RectangleShape) {
                    Text(text = "Mostrar Carta")
                }
                Spacer(modifier = Modifier.size(30.dp))
                Button(onClick = { viewModel.hideElement() },Modifier.weight(1f), shape = RectangleShape) {
                    Text(text = "Esconder Carta")
                }
            }
        }
    }
}