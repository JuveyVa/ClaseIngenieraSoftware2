package com.juvey.examen.screens.gyms.network

import com.juvey.examen.screens.gyms.models.Gym
import retrofit2.http.GET

interface GymService {
    // GET se puede ver en el navegador
    // POST o revisar informacion
    // PUT actualizar datos
    @GET("JuveyVa/23f53cd7cf4b0791c3ab8e5a159d75f3/raw/1fa40a43a158496d13889a229fbb8710cf5ca0ce/gyms.json")
    suspend fun getGyms(): List<Gym>
}