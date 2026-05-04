package com.taverncall.util

import android.content.Context
import android.media.MediaPlayer

class SoundManager(private val context: Context) {
    private var ambientPlayer: MediaPlayer? = null
    private var sfxPlayer: MediaPlayer? = null
    private var globalVolume: Float = 1.0f

    fun playAmbient(resourceId: Int) {
        stopAmbient()
        ambientPlayer = MediaPlayer.create(context, resourceId).apply {
            isLooping = true
            setVolume(globalVolume, globalVolume)
            start()
        }
    }

    fun stopAmbient() {
        ambientPlayer?.apply {
            if (isPlaying) stop()
            release()
        }
        ambientPlayer = null
    }

    fun playSFX(resourceId: Int) {
        sfxPlayer?.release()
        sfxPlayer = MediaPlayer.create(context, resourceId).apply {
            setVolume(globalVolume, globalVolume)
            start()
            setOnCompletionListener { release() }
        }
    }

    fun setVolume(volume: Float) {
        globalVolume = volume
        ambientPlayer?.setVolume(volume, volume)
    }
}
