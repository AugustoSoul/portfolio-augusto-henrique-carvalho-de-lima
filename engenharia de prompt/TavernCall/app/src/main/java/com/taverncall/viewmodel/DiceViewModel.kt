package com.taverncall.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.taverncall.util.DiceManager

class DiceViewModel : ViewModel() {
    private val _rollResult = MutableLiveData<String>()
    val rollResult: LiveData<String> = _rollResult

    private val _history = MutableLiveData<List<String>>(emptyList())
    val history: LiveData<List<String>> = _history

    fun rollDice(characterName: String, sides: Int, modifier: Int, isSecret: Boolean) {
        val (roll, total) = DiceManager.rollWithModifier(sides, modifier)
        val result = DiceManager.formatRollResult(characterName, sides, roll, modifier, total)
        
        if (!isSecret) {
            _rollResult.value = result
        }
        
        val currentHistory = _history.value?.toMutableList() ?: mutableListOf()
        currentHistory.add(0, result)
        if (currentHistory.size > 20) currentHistory.removeAt(currentHistory.size - 1)
        _history.value = currentHistory
    }
}
