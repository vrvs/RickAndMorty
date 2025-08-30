package com.example.rickandmorty.datadomain.character.data.model

data class CharacterListInfoResponse(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String
)