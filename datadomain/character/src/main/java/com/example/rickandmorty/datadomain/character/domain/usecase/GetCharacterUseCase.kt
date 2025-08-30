package com.example.rickandmorty.datadomain.character.domain.usecase

import com.example.rickandmorty.datadomain.base.Result
import com.example.rickandmorty.datadomain.character.domain.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

interface GetCharacterUseCase  {
    operator fun invoke(page: Int): Flow<Result<CharacterEntity>>
}