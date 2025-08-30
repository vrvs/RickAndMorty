package com.example.rickandmorty.feature.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

open class BaseViewModel(val initialState: BaseState) : ViewModel() {

    protected val protectedState = MutableStateFlow<BaseState>(initialState)
    val state: StateFlow<BaseState>
        get() = protectedState

    val userIntent = Channel<BaseIntent>()

    protected val protectedSideEffect = Channel<BaseSideEffect>()
    val sideEffect: ReceiveChannel<BaseSideEffect>
        get() = protectedSideEffect


    override fun onCleared() {
        super.onCleared()
        userIntent.close()
    }
}