package com.taverncall.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.taverncall.databinding.FragmentBattleMapBinding
import com.taverncall.viewmodel.SessionViewModel

class BattleMapFragment : Fragment() {
    private var _binding: FragmentBattleMapBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SessionViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentBattleMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel.tokens.observe(viewLifecycleOwner) { tokens ->
            binding.battleMapView.setTokens(tokens)
        }

        binding.switchGrid.setOnCheckedChangeListener { _, isChecked ->
            binding.battleMapView.setShowGrid(isChecked)
        }

        binding.fabAddToken.setOnClickListener {
            // Aqui abriria um dialog para adicionar token
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
