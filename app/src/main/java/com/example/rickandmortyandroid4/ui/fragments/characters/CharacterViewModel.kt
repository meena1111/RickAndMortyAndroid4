package com.example.rickandmortyandroid4.ui.fragments.characters

import com.example.rickandmortyandroid4.base.BaseViewModel
import com.example.rickandmortyandroid4.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CharacterViewModel @Inject constructor(private val repository: CharacterRepository) :
    BaseViewModel() {

    fun fetchCharacters(page: Int) = repository.fetchCharacter(page)
}
