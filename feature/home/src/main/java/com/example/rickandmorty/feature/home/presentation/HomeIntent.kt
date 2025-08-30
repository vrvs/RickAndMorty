package com.example.rickandmorty.feature.home.presentation

import com.example.rickandmorty.feature.base.BaseIntent

sealed class HomeIntent : BaseIntent() {
    data class CharacterClick(val id: String) : HomeIntent()
    object LoadMore : HomeIntent()
    object InitialLoad : HomeIntent()
}