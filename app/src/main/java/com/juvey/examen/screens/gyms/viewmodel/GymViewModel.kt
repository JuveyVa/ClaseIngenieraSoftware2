package com.juvey.examen.screens.gyms.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juvey.examen.screens.gyms.models.Gym
import com.juvey.examen.screens.gyms.network.RetrofitInstance
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlin.math.log


class GymViewModel: ViewModel() {
    private val ApiGymService = RetrofitInstance.api
    val gyms = MutableStateFlow<List<Gym>>(emptyList())

    fun getGyms() {
        viewModelScope.launch {
            try {
                val response = ApiGymService.getGyms()
                Log.d("GymViewModel", "Gyms: $response")
                if (response.isNotEmpty()) {
                    gyms.value = response
                }
            } catch (e: Exception) {
                Log.e(
                    "GymViewModel",
                    e.message ?: "Error al obtener los gimnasios"
                )
            }
                // Handle errors here
            }
        }
    }
