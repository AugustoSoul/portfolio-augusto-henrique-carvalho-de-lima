package com.taverncall.util

import android.content.Context
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions
import org.jitsi.meet.sdk.JitsiMeetUserInfo
import java.net.URL

object JitsiHelper {
    private const val DEFAULT_SERVER_URL = "https://meet.jit.si"

    fun buildOptions(serverUrl: String?, roomName: String, userName: String?): JitsiMeetConferenceOptions {
        val server = if (serverUrl.isNullOrEmpty()) DEFAULT_SERVER_URL else serverUrl
        
        val userInfo = JitsiMeetUserInfo().apply {
            displayName = userName
        }

        return JitsiMeetConferenceOptions.Builder()
            .setServerURL(URL(server))
            .setRoom(roomName)
            .setUserInfo(userInfo)
            .setFeatureFlag("welcomepage.enabled", false)
            .setFeatureFlag("prejoinpage.enabled", false)
            .setAudioMuted(false)
            .setVideoMuted(false)
            .build()
    }
}
