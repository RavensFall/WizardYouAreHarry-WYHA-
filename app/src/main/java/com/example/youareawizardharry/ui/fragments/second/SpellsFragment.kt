package com.example.youareawizardharry.ui.fragments.second

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.youareawizardharry.R
import com.example.youareawizardharry.databinding.FragmentSpellsBinding

class SpellsFragment : Fragment(R.layout.fragment_spells) {
    private lateinit var binding: FragmentSpellsBinding

    private val args: SpellsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSpellsBinding.bind(view)

        val spell = args.spell

        binding.name.text = "Name:${spell.name}"
        binding.incantation.text="Incantation:${spell.incantation}"
        binding.effect.text="Effect:${spell.effect}"
        binding.canBeVerbal.text="Can Be Verbal:${spell.canBeVerbal.toString()}"
        binding.type.text="Type:${spell.type}"
        binding.light.text="Light:${spell.light}"
        binding.creator.text="Creator:${spell.creator}"



    }
}