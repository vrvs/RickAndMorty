package com.example.rickandmorty.datadomain.character.data.di

import com.example.rickandmorty.datadomain.character.data.datasource.CharacterService
import com.example.rickandmorty.datadomain.character.data.repository.CharacterRepositoryImpl
import com.example.rickandmorty.datadomain.character.domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CharacterDataServiceModule {
    @Provides
    @Singleton
    fun getCharacterService(retrofit: Retrofit): CharacterService {
        return retrofit.create(CharacterService::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class CharacterDataRepositoryModule {

    @Binds
    abstract fun providerRepositoryImpl(repository: CharacterRepositoryImpl) : CharacterRepository
}