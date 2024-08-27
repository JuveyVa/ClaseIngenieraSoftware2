package com.juvey.examen.game

import android.media.MediaPlayer
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.juvey.examen.R
import kotlinx.coroutines.delay


@Composable
fun TimeFireView(viewModel: TimeFireViewModel, navController: NavController) {
    val context = LocalContext.current // Obtén el contexto aquí

    var buttonSize by remember { mutableStateOf(100.dp) } // Tamaño inicial del botón
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }

    val animatedButtonSize by animateDpAsState(
        targetValue = buttonSize,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    // Reproducción y detención del sonido
    LaunchedEffect(viewModel.counter) {
        if (viewModel.counter == 1) {
            mediaPlayer?.release() // Libera el MediaPlayer anterior si existe
            mediaPlayer = MediaPlayer.create(context, R.raw.game).apply {
                isLooping = true
                start()
            }
        }
    }

    LaunchedEffect(viewModel.timeLeft) {
        if (viewModel.timeLeft == 0) {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }



    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "High Score: ${viewModel.counter}", modifier = Modifier.align(Alignment.TopStart))
        Text(text = "Time left ${viewModel.timeLeft} secs ", modifier = Modifier.align(Alignment.TopEnd))
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = viewModel.counter.toString())
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.onButtonClick()
                buttonSize = 120.dp
            }, enabled = viewModel.isButtonEnabled,
            modifier = Modifier.size(animatedButtonSize)
        ) {
            Text(text = "Suma")
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (viewModel.isButtonEnabled == false) {
            Button(onClick = { viewModel.onButtonRestart() }) {
                Text(text = "Restart")
            }
        }
    }
    LaunchedEffect(buttonSize) {
        if (buttonSize > 100.dp) {
            delay(300) // Esperar un poco antes de restablecer el tamaño
            buttonSize = 100.dp // Restablecer el tamaño a su valor original
        }
    }
}

