package com.example.youareawizardharry.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Spells(

    val name: String?,
    val incantation:String?,
    val effect:String?,
    val canBeVerbal:Boolean?,
    val type:String?,
    val light:String?,
    val creator:String?,
):Parcelable
