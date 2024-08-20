package com.juvey.examen.act3

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.juvey.examen.R

@Composable
fun GameView(viewModel: GameViewModel, navController: NavController){
    val resultRandomNumberByViewModel by viewModel.getResult().observeAsState(-1)
    val RandomImage = when(resultRandomNumberByViewModel){
        0 -> R.drawable.roca
        1 -> R.drawable.papel
        2 -> R.drawable.tijeras
        else -> R.drawable.interro
    }


        Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)) {
        Image(painter = painterResource(id = RandomImage), contentDescription = "No jala", modifier = Modifier
            .size(150.dp))

        Button(onClick = { viewModel.playGame() }) {
            Text(text = "Jugar")
        }
    }
}




