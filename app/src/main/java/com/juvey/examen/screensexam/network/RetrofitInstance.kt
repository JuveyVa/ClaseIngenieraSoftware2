package com.juvey.examen.screensexam.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance2 {
    private const val BASE_URL = "https://gist.githubusercontent.com/"
    val api: RestService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RestService::class.java)
    }
}
