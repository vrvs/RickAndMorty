package com.example.rickandmorty.datadomain.character.domain.mapper

import com.example.rickandmorty.datadomain.character.data.model.CharacterListResponse
import com.example.rickandmorty.datadomain.character.domain.entity.CharacterListEntity
import com.example.rickandmorty.datadomain.character.domain.entity.CharacterListInfoEntity
import javax.inject.Inject

class CharacterListMapperImpl @Inject constructor(val map: CharacterMapper): CharacterListMapper  {
    override fun invoke(response: CharacterListResponse): CharacterListEntity {
        return CharacterListEntity(
            info = CharacterListInfoEntity(response.info.pages),
            results = response.results.map { map(it) }
        )
    }

}