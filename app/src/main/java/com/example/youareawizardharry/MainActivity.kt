package com.example.youareawizardharry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv = findViewById<TextView>(R.id.tv)
        val b = findViewById<Button>(R.id.button)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://wizard-world-api.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val SpellsApi = retrofit.create(SpellsApi::class.java)

        b.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val spells = SpellsApi.getSpellsById("Opening Charm")
                runOnUiThread {
                    tv.text = spells[0].name
                }
            }
        }


    }
}