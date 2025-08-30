package com.example.rickandmorty.datadomain.character.domain.di

import com.example.rickandmorty.datadomain.character.domain.mapper.CharacterListMapper
import com.example.rickandmorty.datadomain.character.domain.mapper.CharacterListMapperImpl
import com.example.rickandmorty.datadomain.character.domain.mapper.CharacterMapper
import com.example.rickandmorty.datadomain.character.domain.mapper.CharacterMapperImpl
import com.example.rickandmorty.datadomain.character.domain.usecase.GetCharacterListUseCase
import com.example.rickandmorty.datadomain.character.domain.usecase.GetCharacterListUseCaseImpl
import com.example.rickandmorty.datadomain.character.domain.usecase.GetCharacterUseCase
import com.example.rickandmorty.datadomain.character.domain.usecase.GetCharacterUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class CharacterDomainModule {

    @Binds
    abstract fun getCharacterMapper(mapper: CharacterMapperImpl): CharacterMapper

    @Binds
    abstract fun getCharacterListMapper(mapper: CharacterListMapperImpl): CharacterListMapper

    @Binds
    abstract fun getGetCharacterUseCase(useCase: GetCharacterUseCaseImpl): GetCharacterUseCase

    @Binds
    abstract fun getGetCharacterListUseCase(useCase: GetCharacterListUseCaseImpl): GetCharacterListUseCase
}