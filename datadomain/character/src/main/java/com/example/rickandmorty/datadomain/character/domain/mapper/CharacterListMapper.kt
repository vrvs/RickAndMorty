package com.example.rickandmorty.datadomain.character.domain.mapper

import com.example.rickandmorty.datadomain.character.data.model.CharacterListResponse
import com.example.rickandmorty.datadomain.character.domain.entity.CharacterListEntity

interface CharacterListMapper {
    operator fun invoke(response: CharacterListResponse): CharacterListEntity
}