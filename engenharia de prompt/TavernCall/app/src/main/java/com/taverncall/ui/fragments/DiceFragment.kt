package com.taverncall.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.taverncall.databinding.FragmentDiceBinding
import com.taverncall.viewmodel.DiceViewModel

class DiceFragment : Fragment() {
    private var _binding: FragmentDiceBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DiceViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRollD20.setOnClickListener {
            viewModel.rollDice("Jogador", 20, 0, false)
        }

        viewModel.rollResult.observe(viewLifecycleOwner) { result ->
            binding.tvLastResult.text = result
        }

        viewModel.history.observe(viewLifecycleOwner) { history ->
            binding.tvHistory.text = history.joinToString("\n")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
