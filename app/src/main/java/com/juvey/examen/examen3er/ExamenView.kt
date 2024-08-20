package com.juvey.examen.examen3er

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.juvey.examen.R
import com.juvey.examen.act2.SoccerScoreLocalModel

@Composable
fun ExamenView(viewModel : ExamenViewModel, navController: NavController){
    val totallitros by viewModel.getTotal().observeAsState(0.0)

    Column (modifier = Modifier
        .fillMaxWidth()
        .size(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "¿Cuánta agua tomaste hoy?", fontSize = 20.sp, modifier = Modifier.padding(20.dp))
        Row {
            Image(painter = painterResource(id = R.drawable.agualitro),
                contentDescription = "No jala",
                modifier = Modifier
                    .size(150.dp)
                    .clickable {
                        Log.d("sumarr", "local")
                        //viewModel.incrementTotalLitro(varLitros(totallitros))
                        viewModel.totales(varTotal(total = 1.0))

                    })
            Text(text = "1L   ", modifier = Modifier.padding(20.dp), fontSize = 30.sp)
        }
        Row {
            Image(painter = painterResource(id = R.drawable.aguamedio),
                contentDescription = "No jala",
                modifier = Modifier
                    .size(150.dp)
                    .clickable {
                        Log.d("sumarr", "local")
                        //viewModel.incrementTotalMedio(varMedio(totallitros))
                        viewModel.totales(varTotal(total = 0.500))
                    })
            Text(text = "500ml", modifier = Modifier.padding(20.dp), fontSize = 30.sp)
        }
        Row {
            Image(painter = painterResource(id = R.drawable.vasoagua),
                contentDescription = "No jala",
                modifier = Modifier
                    .size(150.dp)
                    .clickable {
                        Log.d("sumarr", "local")
                        //viewModel.incrementTotalCuarto(varCuarto(totallitros))
                        viewModel.totales(varTotal(total = 0.255))
                    })
            Text(text = "250ml", modifier = Modifier.padding(20.dp), fontSize = 30.sp)
        }
        Text(text = "Tu has tomado: ${totallitros} Litro(s)", modifier = Modifier.padding(20.dp), fontSize = 20.sp)
        Button(onClick = { viewModel.resetTotal() }) {
            Text(text = "Reiniciar")

        }
    }
}


