package com.juvey.examen.act2

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.juvey.examen.R


@Composable
fun SoccerView(viewModel: SoccerScoreViewModel, navController: NavController){
    val localScoreResult by viewModel.getLocalScore().observeAsState(0)
    val visitScoreResult by viewModel.getVisitScore().observeAsState(0)

    Column (modifier = Modifier
        .fillMaxWidth()
        .size(20.dp), verticalArrangement = Arrangement.Center){
        Text(
            text = "Marcador Oficial", fontSize = 50.sp)
        Row (modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)) {
            Image(painter = painterResource(id = R.drawable.chivas), contentDescription = "No jala", modifier = Modifier
                .size(150.dp)
                .clickable {
                    Log.d("sumarr", "local")
                    viewModel.incrementLocalScore(SoccerScoreLocalModel(localScoreResult))
                })
            Text(text = "${localScoreResult}", modifier = Modifier.padding(20.dp), fontSize = 50.sp)

            Text(text = "${visitScoreResult}", modifier = Modifier.padding(20.dp), fontSize = 50.sp)
            Image(painter = painterResource(id = R.drawable.cacamerica), contentDescription = "No jala", modifier = Modifier
                .size(150.dp)
                .clickable {
                    print("sumar")
                    Log.d("sumarr", "visitante")
                    viewModel.incrementVisitScore(SoccerScoreVisitModel(visitScoreResult))
                })
    }

        }

    }


