package com.taverncall.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.taverncall.databinding.ActivityCharacterListBinding

class CharacterListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCharacterListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // Lógica para listar personagens do Room Database
    }
}
