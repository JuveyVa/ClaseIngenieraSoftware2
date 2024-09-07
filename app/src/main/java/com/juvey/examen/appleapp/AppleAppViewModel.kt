package com.juvey.examen.appleapp


import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

data class varTotal(val total: Int)


class AppleAppViewModel : ViewModel() {

    private val actualProductionTotal = MutableLiveData(0)
    private var totalProduction = MutableLiveData(0)
    private val actualProduction = MutableLiveData(0)


    fun getTotal(): MutableLiveData<Int> = actualProductionTotal
    fun getTotalProduction(): MutableLiveData<Int> = totalProduction

    fun totales(total: varTotal) {
        val sum = total.total + (actualProductionTotal.value ?: 0)
        actualProductionTotal.postValue(sum)
    }

    fun calculateActualProduction(ap: Int): Int {
        val totalpa = ap * 80
        actualProduction.postValue(totalpa)
        return totalpa
    }

    fun storeTotalProduction(pt: Int) {
        totalProduction.postValue(pt)
    }


    fun calculateTotalProduction(pt: Int): Int {
        val totalp = pt * 80
        totalProduction.postValue(totalp)
        return totalp
    }

    fun calculatePercentage(actual: Int, total: Int): Int {
        if (total == 0) return 0
        return (actual * 100) / total
    }


}

