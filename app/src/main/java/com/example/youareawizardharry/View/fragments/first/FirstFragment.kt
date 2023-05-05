package com.example.youareawizardharry.View.fragments.first

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.youareawizardharry.R
import com.example.youareawizardharry.data.models.Spells
import com.example.youareawizardharry.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {
    private lateinit var binding: FragmentFirstBinding
    var spellList = emptyList<Spells>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstBinding.bind(view)

        val spellsViewModel = ViewModelProvider(this).get(FirstViewModel::class.java)

        spellsViewModel.listSpellsLiveData.observe(viewLifecycleOwner) {
            spellList = it
        }

        spellsViewModel.isLoaded.observe(viewLifecycleOwner) {
            if (it) {
                spellInfo()

                spellsViewModel.isLoaded.postValue(false)
            }
        }

        binding.spellFinder.setOnClickListener {
            if (binding.findEditText.text.isEmpty() || binding.findEditText.text.isBlank()) {
                Toast.makeText(requireContext(), "Enter the name of the spell", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val spellName = binding.findEditText.text.toString()
            spellsViewModel.getSpells(spellName)
        }

    }

    fun spellInfo() {
        if(spellList.isEmpty()){
            Toast.makeText(requireContext(), "Spell not found", Toast.LENGTH_SHORT).show()
            return
        }
        val direction =
            FirstFragmentDirections.actionFirstFragmentToSpellsFragment(spellList[0])
        findNavController().navigate(direction)
    }
}