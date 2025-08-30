package com.example.rickandmorty.datadomain.character.data.repository

import com.example.rickandmorty.datadomain.character.data.datasource.CharacterService
import com.example.rickandmorty.datadomain.character.data.model.CharacterListResponse
import com.example.rickandmorty.datadomain.character.data.model.CharacterResponse
import com.example.rickandmorty.datadomain.character.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val service: CharacterService
) : CharacterRepository {
    override suspend fun getCharacterList(page: Int): CharacterListResponse {
        return service.getCharacters(page)
    }

    override suspend fun getCharacter(id: Int): CharacterResponse {
        return service.getCharacter(id)
    }
}