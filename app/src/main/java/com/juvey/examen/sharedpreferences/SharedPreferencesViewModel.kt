package com.juvey.examen.sharedpreferences

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val sharedPreferences = application.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    // Estado del nombre que será observado desde la UI
    private val _name = MutableStateFlow(sharedPreferences.getString("name", "") ?: "")
    val name: StateFlow<String> = _name

    // Método para guardar el nombre en SharedPreferences
    fun saveName(newName: String) {
        viewModelScope.launch {
            sharedPreferences.edit().putString("name", newName).apply()
            _name.value = newName
        }
    }
}