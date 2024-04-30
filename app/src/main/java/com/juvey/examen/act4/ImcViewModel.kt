package com.juvey.examen.act4

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class ImcModel(val height: Double, val weight: Double)

class ImcViewModel : ViewModel() {
    private val resultImc = MutableLiveData(0.0)
    fun getResult(): LiveData<Double> = resultImc

    private val resultImcPeso = MutableLiveData("")
    fun getResultPeso(): LiveData<String> = resultImcPeso

    fun calculateImc(calc: ImcModel) {
        val Imc = calc.weight / (calc.height * calc.height)
        if (Imc < 18.5) {
            resultImc.postValue(Imc)
            resultImcPeso.postValue("El paciente tiene bajo peso")
        }
        else if (Imc >= 18.5 && Imc <= 24.9) {
            resultImc.postValue(Imc)
            resultImcPeso.postValue("El paciente tiene un peso normal")
        }
        else if (Imc >= 25 && Imc <= 29.9) {
            resultImc.postValue(Imc)
            resultImcPeso.postValue("El paciente tiene sobrepeso")
        }
        else if (Imc >= 30) {
            resultImc.postValue(Imc)
            resultImcPeso.postValue("El paciente tiene obesidad")
    }
}
}