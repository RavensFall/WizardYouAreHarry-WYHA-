package com.example.youareawizardharry.data.interfaces

import com.example.youareawizardharry.data.models.Spells
import retrofit2.http.GET
import retrofit2.http.Query

interface SpellsApi {
    @GET("Spells")
   suspend fun getSpellsById(@Query("Name") Name:String): List<Spells>
}