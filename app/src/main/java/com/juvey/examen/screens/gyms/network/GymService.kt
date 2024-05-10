package com.juvey.examen.screens.gyms.network

import com.juvey.examen.screens.gyms.models.Gym
import retrofit2.http.GET

interface GymService {
    @GET("JuveyVa/23f53cd7cf4b0791c3ab8e5a159d75f3/raw/db29bf2737bcdd7fb012b8be5914b617b14c7ba1/")
    suspend fun getGyms(): List<Gym>
}