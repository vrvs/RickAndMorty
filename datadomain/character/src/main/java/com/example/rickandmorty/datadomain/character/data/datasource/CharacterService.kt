package com.example.rickandmorty.datadomain.character.data.datasource
import retrofit2.http.GET


import com.example.rickandmorty.datadomain.character.data.model.CharacterListResponse
import com.example.rickandmorty.datadomain.character.data.model.CharacterResponse
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {
    @Headers("Accept: application/json")
    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int = 1,
    ): CharacterListResponse

    @Headers("Accept: application/json")
    @GET("character/{id}")
    suspend fun getCharacter(
        @Path("id") id: Int
    ): CharacterResponse
}