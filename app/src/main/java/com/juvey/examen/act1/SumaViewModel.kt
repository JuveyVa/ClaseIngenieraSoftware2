package com.juvey.examen.act1

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class SumModel(val number1: Int, val number2: Int, val number3: Int)

class SumViewModel : ViewModel() {
    private val resultSum = MutableLiveData(0)
    fun getResult(): LiveData<Int> = resultSum

    fun sumNumbers(sum: SumModel) {
        print("intento de sumar")
        Log.i("Number1", sum.number1.toString())
        Log.i("Number2", sum.number2.toString())
        Log.i("Number3", sum.number3.toString())
        Log.e("Log", "Hubo error")
        resultSum.postValue(sum.number1 + sum.number2 + sum.number3)
    }
}