package com.example.rickandmorty.feature.home.presentation

import com.example.rickandmorty.feature.base.BaseSideEffect

sealed class HomeSideEffect: BaseSideEffect() {
    data class GoToCharacter(val id: String) : HomeSideEffect()
}