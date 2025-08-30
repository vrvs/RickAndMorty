package com.example.rickandmorty.feature.home.presentation

import com.example.rickandmorty.datadomain.character.domain.entity.CharacterListEntity
import com.example.rickandmorty.feature.base.BaseState

sealed class HomeState: BaseState() {
    object HomeLoading : HomeState()
    data class HomeUI(
        val entity: CharacterListEntity,
        val isLoadingMore: Boolean = false,
        val canLoadMore: Boolean = false,
        val loadMoreError: String? = null
    ) : HomeState()
    data class HomeError(val message: String) : HomeState()
}