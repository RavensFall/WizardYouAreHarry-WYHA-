package com.example.youareawizardharry

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SpellsApi {
    @GET("Spells")
   suspend fun getSpellsById(@Query("Name") Name:String): List<Spells>
}