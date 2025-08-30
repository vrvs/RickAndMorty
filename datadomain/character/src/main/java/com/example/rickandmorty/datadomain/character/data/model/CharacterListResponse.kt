package com.example.rickandmorty.datadomain.character.data.model

data class CharacterListResponse(
    val info: CharacterListInfoResponse,
    val results: List<CharacterResponse>
)