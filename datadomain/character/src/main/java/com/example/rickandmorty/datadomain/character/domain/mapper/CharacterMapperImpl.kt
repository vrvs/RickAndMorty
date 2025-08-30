package com.example.rickandmorty.datadomain.character.domain.mapper

import com.example.rickandmorty.datadomain.character.data.model.CharacterResponse
import com.example.rickandmorty.datadomain.character.domain.entity.CharacterEntity
import javax.inject.Inject

class CharacterMapperImpl @Inject constructor(): CharacterMapper {
    override fun invoke(response: CharacterResponse): CharacterEntity {
        return CharacterEntity(
            id = response.id,
            name = response.name,
            status = response.status,
            species = response.species,
            type = response.type,
            gender = response.gender,
            image = response.image
        )
    }
}