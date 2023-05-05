package com.example.youareawizardharry.ui.fragments.first

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.youareawizardharry.data.models.Spells
import com.example.youareawizardharry.domain.SpellsUseCase
import kotlinx.coroutines.launch

class FirstViewModel: ViewModel() {

    val listSpellsLiveData = MutableLiveData<List<Spells>>()

    val isLoaded = MutableLiveData<Boolean>()

    fun getSpells(spell: String) {
        viewModelScope.launch {
            val spells = SpellsUseCase.api.getSpellsById(spell)
            listSpellsLiveData.postValue(spells)
            isLoaded.postValue(true)
        }
    }
}