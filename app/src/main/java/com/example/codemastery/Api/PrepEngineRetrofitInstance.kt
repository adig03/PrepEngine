package com.example.codemastery.Api

import com.example.codemastery.util.Constants.Companion.PrepEngineBASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PrepEngineRetrofitInstance {

    // Lazy initialization of Retrofit instance
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(PrepEngineBASE_URL) // Base URL for your API
            .addConverterFactory(GsonConverterFactory.create()) // Converts JSON to Kotlin objects
            .build()
    }

    // Lazy initialization of API service
    val api: PrepEngineBackendService by lazy {
        retrofit.create(PrepEngineBackendService::class.java)
    }
}
