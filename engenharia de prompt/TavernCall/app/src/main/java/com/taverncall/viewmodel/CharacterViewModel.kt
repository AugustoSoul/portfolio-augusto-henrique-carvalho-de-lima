package com.taverncall.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.taverncall.database.AppDatabase
import com.taverncall.database.CharacterEntity
import kotlinx.coroutines.launch

class CharacterViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application).characterDao()
    val allCharacters: LiveData<List<CharacterEntity>> = dao.getAllCharacters()

    private val _selectedCharacter = MutableLiveData<CharacterEntity?>()
    val selectedCharacter: LiveData<CharacterEntity?> = _selectedCharacter

    fun selectCharacter(character: CharacterEntity) {
        _selectedCharacter.value = character
    }

    fun insert(character: CharacterEntity) = viewModelScope.launch {
        dao.insertCharacter(character)
    }

    fun update(character: CharacterEntity) = viewModelScope.launch {
        dao.updateCharacter(character)
    }

    fun delete(character: CharacterEntity) = viewModelScope.launch {
        dao.deleteCharacter(character)
    }
}
