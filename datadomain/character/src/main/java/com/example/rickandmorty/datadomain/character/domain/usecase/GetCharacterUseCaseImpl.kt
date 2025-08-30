package com.example.rickandmorty.datadomain.character.domain.usecase

import com.example.rickandmorty.datadomain.base.Result
import com.example.rickandmorty.datadomain.character.domain.entity.CharacterEntity
import com.example.rickandmorty.datadomain.character.domain.mapper.CharacterMapper
import com.example.rickandmorty.datadomain.character.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharacterUseCaseImpl @Inject constructor(
    private val repository: CharacterRepository,
    private val map: CharacterMapper
): GetCharacterUseCase {
    override fun invoke(page: Int): Flow<Result<CharacterEntity>> = flow {
        try {
            emit(Result.Success(map(repository.getCharacter(page))))
        } catch (exception: Exception) {
            emit(Result.Error(exception))
        }
    }
}