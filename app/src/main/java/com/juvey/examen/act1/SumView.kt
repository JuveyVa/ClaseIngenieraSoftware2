package com.juvey.examen.act1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable

fun SumView(viewModel: SumViewModel){
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var number3 by remember { mutableStateOf("") }

    val resultSumByViewModel by viewModel.getResult().observeAsState(0)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {

        TextField(value = number1, onValueChange = { number1 = it }, label = { Text(text = "Numero 1")})
        TextField(value = number2, onValueChange = { number2 = it }, label = { Text(text = "Numero 2")})
        TextField(value = number3, onValueChange = { number3 = it }, label = { Text(text = "Numero 3")})
        Button(onClick = { viewModel.sumNumbers(SumModel(number1.toInt(), number2.toInt(), number3.toInt())) }) {
            Text(text = "Sumar")
        }
        Text(text = "El reultado es: ${resultSumByViewModel}")
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    SumView(SumViewModel())
}
