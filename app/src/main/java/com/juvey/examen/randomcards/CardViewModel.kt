package com.juvey.examen.randomcards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.juvey.examen.R

class CardViewModel : ViewModel(){
    // El identificador de la imagen que va a mostrar
    val imageToShow = MutableLiveData(R.drawable.back)

    // Función que se va a mandar llamar desde la vista
    fun getRandomImage(): MutableLiveData<Int> = imageToShow

    fun getRandomElement() {
        val random = (0..12).random()

        when (random) {
            0 -> return imageToShow.postValue(R.drawable.h01)
            1 -> return imageToShow.postValue(R.drawable.h02)
            2 -> return imageToShow.postValue(R.drawable.h03)
            3 -> return imageToShow.postValue(R.drawable.h04)
            4 -> return imageToShow.postValue(R.drawable.h05)
            5 -> return imageToShow.postValue(R.drawable.h06)
            6 -> return imageToShow.postValue(R.drawable.h07)
            7 -> return imageToShow.postValue(R.drawable.h08)
            8 -> return imageToShow.postValue(R.drawable.h09)
            9 -> return imageToShow.postValue(R.drawable.h10)
            10 -> return imageToShow.postValue(R.drawable.hc1j)
            11 -> return imageToShow.postValue(R.drawable.hc2q)
            12 -> return imageToShow.postValue(R.drawable.hc3k)
        }

    }

    fun hideElement() {
        imageToShow.postValue(R.drawable.back)
    }
}

