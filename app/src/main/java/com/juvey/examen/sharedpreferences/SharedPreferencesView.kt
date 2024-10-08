package com.juvey.examen.sharedpreferences

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun SharedPreferencesView(mainViewModel: MainViewModel = viewModel(), navController: NavController) {
    // Observamos el valor del nombre desde el ViewModel
    val name by mainViewModel.name.collectAsState()

    var inputText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Validamos que el nombre no sea nulo o vacío antes de mostrarlo
        if (name.isNotEmpty()) {
            Text(text = "Nombre guardado: $name", style = MaterialTheme.typography.headlineSmall)
        } else {
            Text(text = "No hay nombre guardado", style = MaterialTheme.typography.headlineSmall)
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Introduce tu nombre") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            mainViewModel.saveName(inputText)
        }) {
            Text("Guardar Nombre")
        }
    }
}