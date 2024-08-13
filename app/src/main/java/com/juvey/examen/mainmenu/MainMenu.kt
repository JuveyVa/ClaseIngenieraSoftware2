package com.juvey.examen.mainmenu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juvey.examen.act1.SumView
import com.juvey.examen.act1.SumViewModel

@Composable
fun MainMenu() {

    Column(modifier = androidx.compose.ui.Modifier.padding(40.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally) {
        Text(text = "Main Menu", fontSize = 20.sp, modifier = androidx.compose.ui.Modifier.padding(20.dp),
            color = androidx.compose.ui.graphics.Color.Black)
        Button(onClick = {  }) {
            Text(text = "SumaView")
        }
        Button(onClick = {  }) {
            Text(text = "SoccerView")
        }
        Button(onClick = {  }) {
            Text(text = "GameView")
        }
        Button(onClick = {  }) {
            Text(text = "ImcView")
        }
        Button(onClick = {  }) {
            Text(text = "ExamenView")
        }
        Button(onClick = {  }) {
            Text(text = "GymView")
        }
        Button(onClick = { }) {
            Text(text = "RestView")
        }
    }
}
