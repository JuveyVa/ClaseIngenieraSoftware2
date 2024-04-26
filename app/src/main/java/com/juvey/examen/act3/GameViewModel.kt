package com.juvey.examen.act3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private val resultGame = MutableLiveData(-1)
    fun getResult(): LiveData<Int> = resultGame

    fun playGame() {
        print("intento de jugar")
        resultGame.postValue((0..2).random())
    }
}