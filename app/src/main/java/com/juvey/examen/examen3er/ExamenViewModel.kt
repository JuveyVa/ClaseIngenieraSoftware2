package com.juvey.examen.examen3er

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



data class varTotal(val total: Double)

class ExamenViewModel : ViewModel() {
    private val totalWaterConsume = MutableLiveData(0.0)
    fun getTotal(): MutableLiveData<Double> = totalWaterConsume


    fun totales(total: varTotal){
        val total: Double = total.total + (totalWaterConsume.value ?: 0.0)
        totalWaterConsume.postValue(total)
    }

    fun resetTotal(){
        totalWaterConsume.postValue(0.0)
    }
}
