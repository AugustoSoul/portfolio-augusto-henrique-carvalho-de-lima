package com.taverncall.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.taverncall.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnJoinSession.setOnClickListener {
            val roomName = binding.etRoomName.text.toString()
            if (roomName.isNotEmpty()) {
                val intent = Intent(this, SessionActivity::class.java).apply {
                    putExtra("ROOM_NAME", roomName)
                }
                startActivity(intent)
            }
        }

        binding.btnManageCharacters.setOnClickListener {
            startActivity(Intent(this, CharacterListActivity::class.java))
        }
    }
}
