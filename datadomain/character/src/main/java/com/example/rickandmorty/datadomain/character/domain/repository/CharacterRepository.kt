package com.example.rickandmorty.datadomain.character.domain.repository

import com.example.rickandmorty.datadomain.character.data.model.CharacterListResponse
import com.example.rickandmorty.datadomain.character.data.model.CharacterResponse

interface CharacterRepository {
    suspend fun getCharacterList(page: Int = 1): CharacterListResponse
    suspend fun getCharacter(id: Int): CharacterResponse
}