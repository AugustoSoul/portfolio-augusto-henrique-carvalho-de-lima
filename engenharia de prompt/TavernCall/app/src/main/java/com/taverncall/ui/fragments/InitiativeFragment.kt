package com.taverncall.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.taverncall.databinding.FragmentInitiativeBinding
import com.taverncall.viewmodel.SessionViewModel

class InitiativeFragment : Fragment() {
    private var _binding: FragmentInitiativeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SessionViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentInitiativeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.btnNextTurn.setOnClickListener {
            // Lógica de próximo turno
        }

        viewModel.turnTimer.observe(viewLifecycleOwner) { seconds ->
            binding.tvTimer.text = seconds.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
