package com.taverncall.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.taverncall.R
import com.taverncall.databinding.ActivitySessionBinding
import com.taverncall.ui.fragments.*
import com.taverncall.util.JitsiHelper
import org.jitsi.meet.sdk.JitsiMeetView

class SessionActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySessionBinding
    private var jitsiView: JitsiMeetView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySessionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val roomName = intent.getStringExtra("ROOM_NAME") ?: "TavernCallRoom"
        setupJitsi(roomName)
        setupTabs()
        
        // Iniciar com a aba de Dados
        replaceFragment(DiceFragment())
    }

    private fun setupJitsi(roomName: String) {
        jitsiView = JitsiMeetView(this)
        val options = JitsiHelper.buildOptions(null, roomName, "Jogador")
        jitsiView?.join(options)
        binding.jitsiContainer.addView(jitsiView)
    }

    private fun setupTabs() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> replaceFragment(DiceFragment())
                    1 -> replaceFragment(CharacterSheetFragment())
                    2 -> replaceFragment(BattleMapFragment())
                    3 -> replaceFragment(SoundboardFragment())
                    4 -> replaceFragment(InitiativeFragment())
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        jitsiView?.dispose()
        jitsiView = null
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // Lógica para sair da sala Jitsi
    }
}
