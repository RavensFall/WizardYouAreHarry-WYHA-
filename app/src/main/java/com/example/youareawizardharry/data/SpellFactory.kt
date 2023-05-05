package com.example.youareawizardharry.data

import retrofit2.Retrofit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory

object SpellFactory {
    private val BASE_URL = "https://wizard-world-api.herokuapp.com/"
    val SpellsApi = retrofitCreate().create(com.example.youareawizardharry.data.interfaces.SpellsApi::class.java)

    private fun retrofitCreate(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            return retrofit

    }
}