package com.juvey.examen.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimeFireViewModel : ViewModel() {
    // Varibañe que va a mostrar el tiempo restante y se incializa en 0
    var counter by mutableStateOf(0)
        private set

    // Variable que va a mostrar el tiempo faltante
    var timeLeft by mutableStateOf(10)
        private set

    // Variable que va a habilitar o deshabilitar el boton
    var isButtonEnabled by mutableStateOf(true)
        private set

    // Variable que va a manejar el tiempo de la tarea
    private var timerJob: Job? = null

    // Funcion que se ejecuta al presionar el boton
    fun onButtonClick(){
        counter++
        if (timerJob == null || timeLeft == 0){
            startTimer()
        }
    }

    private fun startTimer(){
        timerJob?.cancel()
        isButtonEnabled = true
        timerJob = viewModelScope.launch {
            while (timeLeft > 0) {
                delay(1000L)
                timeLeft--
            }
            isButtonEnabled = false
            timerJob = null
        }
    }
    fun onButtonRestart(){
        timeLeft = 10
        isButtonEnabled = true
        counter = 0
    }
}