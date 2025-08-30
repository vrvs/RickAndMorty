package com.example.rickandmorty.datadomain.character.domain.usecase

import com.example.rickandmorty.datadomain.base.Result
import com.example.rickandmorty.datadomain.character.domain.entity.CharacterListEntity
import com.example.rickandmorty.datadomain.character.domain.mapper.CharacterListMapper
import com.example.rickandmorty.datadomain.character.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharacterListUseCaseImpl @Inject constructor(
    private val repository: CharacterRepository,
    private val map: CharacterListMapper
): GetCharacterListUseCase {
    override fun invoke(page: Int): Flow<Result<CharacterListEntity>> = flow {
        try {
            emit(Result.Success(map(repository.getCharacterList(page))))
        } catch (exception: Exception) {
            emit(Result.Error(exception))
        }

    }
}