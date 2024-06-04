package com.juvey.examen.screensexam.viewmodel

import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juvey.examen.screensexam.models.Rest
import com.juvey.examen.screensexam.network.RetrofitInstance2
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class RestViewModel: ViewModel() {
    private val ApiRestService = RetrofitInstance2.api
    val rests = MutableStateFlow<List<Rest>>(emptyList())

    fun getRests() {
        viewModelScope.launch {
            try {
                val response = ApiRestService.getRest()
                Log.d("RestViewModel", "rests: $response")
                if (response.isNotEmpty()) {
                    rests.value = response
                }
            } catch (e: Exception) {
                Log.e(
                    "RestViewModel",
                    e.message ?: "Error al obtener los restaurantes"
                )
            }
            // Handle errors here
        }
    }

}
