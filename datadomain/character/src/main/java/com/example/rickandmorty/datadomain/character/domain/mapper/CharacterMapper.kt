package com.example.rickandmorty.datadomain.character.domain.mapper

import com.example.rickandmorty.datadomain.character.data.model.CharacterResponse
import com.example.rickandmorty.datadomain.character.domain.entity.CharacterEntity

interface CharacterMapper {
    operator fun invoke(response: CharacterResponse): CharacterEntity
}