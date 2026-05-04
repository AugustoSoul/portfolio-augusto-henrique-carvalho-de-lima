package com.taverncall.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.taverncall.databinding.FragmentCharacterSheetBinding
import com.taverncall.viewmodel.CharacterViewModel

class CharacterSheetFragment : Fragment() {
    private var _binding: FragmentCharacterSheetBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CharacterViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCharacterSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel.selectedCharacter.observe(viewLifecycleOwner) { character ->
            character?.let {
                binding.etCharacterName.setText(it.name)
                binding.etLevel.setText(it.level.toString())
                binding.etHpCurrent.setText(it.currentHp.toString())
                binding.etHpMax.setText(it.maxHp.toString())
                // Preencher demais campos...
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
