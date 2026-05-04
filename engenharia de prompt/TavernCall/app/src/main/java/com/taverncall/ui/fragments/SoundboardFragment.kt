package com.taverncall.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import com.taverncall.R
import com.taverncall.databinding.FragmentSoundboardBinding
import com.taverncall.util.SoundManager

class SoundboardFragment : Fragment() {
    private var _binding: FragmentSoundboardBinding? = null
    private val binding get() = _binding!!
    private lateinit var soundManager: SoundManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSoundboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        soundManager = SoundManager(requireContext())

        binding.btnStopAll.setOnClickListener { soundManager.stopAmbient() }

        binding.seekBarVolume.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                soundManager.setVolume(progress / 100f)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Configurar botões de som (exemplo)
        // binding.btnTavern.setOnClickListener { soundManager.playAmbient(R.raw.taverna) }
        // binding.btnDiceSfx.setOnClickListener { soundManager.playSFX(R.raw.dado_rolando) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        soundManager.stopAmbient()
        _binding = null
    }
}
