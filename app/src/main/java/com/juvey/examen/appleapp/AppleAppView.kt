package com.juvey.examen.appleapp

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.juvey.examen.R
import com.juvey.examen.examen3er.varTotal

@Composable
fun AppleAppView(viewModel: AppleAppViewModel, navController: NavController) {
    var percent by remember { mutableStateOf("0") }
    var pt by remember { mutableStateOf("200") }
    var pa by remember { mutableStateOf("0") }
    val totalProduction by viewModel.getTotalProduction().observeAsState(0)
    val totalpa by viewModel.getTotal().observeAsState(0)
    val context = LocalContext.current
    var backgroundColor by remember { mutableStateOf(Color.White) }


    Box(modifier = Modifier
        .fillMaxSize()
        .background(backgroundColor)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.apples),
                contentDescription = "No jala",
                modifier = Modifier.size(250.dp)
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Producción Total", modifier = Modifier
                    .padding(end = 16.dp)
                    .padding(start = 16.dp))
                TextField(
                    value = pt,
                    onValueChange = { newValue ->
                        pt = newValue
                        val ptValue = pt.toIntOrNull() ?: 0
                        viewModel.storeTotalProduction(ptValue) },
                    modifier = Modifier
                        .size(150.dp, 50.dp)
                        .padding(end = 16.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Image(
                    painter = painterResource(id = R.drawable.apple),
                    contentDescription = "No jala",
                    modifier = Modifier
                        .size(50.dp)
                        .clickable {
                            val ptValue = pt.toIntOrNull() ?: 0
                            viewModel.storeTotalProduction(ptValue)
                            val totalProductionMultiplied = ptValue * 80
                            Toast.makeText(
                                context,
                                "La producción total es $totalProductionMultiplied manzanas",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                )
            }
            Spacer(modifier = Modifier.size(30.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Producción Actual", modifier = Modifier
                    .padding(end = 16.dp)
                    .padding(start = 16.dp))
                TextField(
                    value = totalpa.toString(),
                    onValueChange = { },
                    modifier = Modifier.size(150.dp, 50.dp).padding(end = 16.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                    ),
                    enabled = false,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Image(
                    painter = painterResource(id = R.drawable.apple),
                    contentDescription = "Calcular producción actual",
                    modifier = Modifier
                        .size(50.dp)
                        .clickable {
                            val productionValue = viewModel.calculateActualProduction(totalpa)
                            Toast.makeText(
                                context,
                                "La producción actual es ${productionValue} manzanas",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                )
            }
            Spacer(modifier = Modifier.size(30.dp))
            Row {
                Button(onClick = { viewModel.totales(varTotal(total = 5)) }, shape = RectangleShape) {
                    Text(text = "+5")
                }
                Spacer(modifier = Modifier.size(10.dp))
                Button(onClick = { viewModel.totales(varTotal(total = 15)) }, shape = RectangleShape) {
                    Text(text = "+15")
                }
                Spacer(modifier = Modifier.size(10.dp))
                Button(onClick = { viewModel.totales(varTotal(total = 30)) }, shape = RectangleShape) {
                    Text(text = "+30")
                }
                Spacer(modifier = Modifier.size(10.dp))
                Button(onClick = { viewModel.totales(varTotal(total = 50)) }, shape = RectangleShape) {
                    Text(text = "+50")
                }
            }
            Spacer(modifier = Modifier.size(30.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Porcentaje", modifier = Modifier.padding(end = 16.dp))
                TextField(
                    value = percent,
                    onValueChange = { },
                    enabled = false,
                    modifier = Modifier.size(150.dp, 50.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                    )
                )
            }
            Spacer(modifier = Modifier.size(30.dp))
            Button(onClick = {
                val calculatedPercent = viewModel.calculatePercentage(totalpa, totalProduction)
                percent = calculatedPercent.toString()
                backgroundColor = if (calculatedPercent > 70) Color.Red else Color.White
                Toast.makeText(
                    context,
                    "El porcentaje es ${calculatedPercent}%",
                    Toast.LENGTH_SHORT
                ).show()
            }, shape = RectangleShape) {
                Text(text = "Calcular")
            }
        }
    }
}

