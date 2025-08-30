package com.example.rickandmorty.datadomain.character.domain.usecase


import com.example.rickandmorty.datadomain.base.Result
import com.example.rickandmorty.datadomain.character.domain.entity.CharacterListEntity
import kotlinx.coroutines.flow.Flow

interface GetCharacterListUseCase  {
    operator fun invoke(page: Int = 1): Flow<Result<CharacterListEntity>>
}