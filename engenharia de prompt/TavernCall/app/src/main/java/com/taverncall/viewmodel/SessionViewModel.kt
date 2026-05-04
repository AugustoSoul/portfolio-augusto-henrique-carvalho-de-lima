package com.taverncall.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.taverncall.model.MapToken

class SessionViewModel : ViewModel() {
    private val _tokens = MutableLiveData<List<MapToken>>(emptyList())
    val tokens: LiveData<List<MapToken>> = _tokens

    private val _turnTimer = MutableLiveData<Int>(30)
    val turnTimer: LiveData<Int> = _turnTimer

    private val _activeTab = MutableLiveData<Int>(0)
    val activeTab: LiveData<Int> = _activeTab

    fun addToken(token: MapToken) {
        val current = _tokens.value?.toMutableList() ?: mutableListOf()
        current.add(token)
        _tokens.value = current
    }

    fun updateToken(token: MapToken) {
        val current = _tokens.value?.toMutableList() ?: mutableListOf()
        val index = current.indexOfFirst { it.id == token.id }
        if (index != -1) {
            current[index] = token
            _tokens.value = current
        }
    }

    fun removeToken(tokenId: String) {
        val current = _tokens.value?.toMutableList() ?: mutableListOf()
        current.removeAll { it.id == tokenId }
        _tokens.value = current
    }

    fun setTimer(seconds: Int) {
        _turnTimer.value = seconds
    }

    fun setActiveTab(index: Int) {
        _activeTab.value = index
    }
}
