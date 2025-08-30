package com.example.rickandmorty.datadomain.character.domain.entity

data class CharacterListEntity(
    val info: CharacterListInfoEntity,
    val results: List<CharacterEntity>
)