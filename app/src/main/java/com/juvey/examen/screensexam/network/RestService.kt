package com.juvey.examen.screensexam.network

import com.juvey.examen.screensexam.models.Rest
import retrofit2.http.GET

interface RestService {
    // GET se puede ver en el navegador
    // POST o revisar informacion
    // PUT actualizar datos
    @GET("JuveyVa/fdb480124d291df328933504a838ff74/raw/1a4bbd2017e2ba1366c7f6354f06d0bd79592728/restaurantes.json")
    suspend fun getRest(): List<Rest>
}