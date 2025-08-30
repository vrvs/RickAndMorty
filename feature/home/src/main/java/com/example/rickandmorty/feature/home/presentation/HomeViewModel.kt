package com.example.rickandmorty.feature.home.presentation

import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.datadomain.base.Result
import com.example.rickandmorty.datadomain.character.domain.entity.CharacterListEntity
import com.example.rickandmorty.datadomain.character.domain.usecase.GetCharacterListUseCase
import com.example.rickandmorty.feature.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCharacter: GetCharacterListUseCase
) : BaseViewModel(HomeState.HomeLoading) {

    private val nextPage = AtomicInteger(1)

    init {
        performUserIntent()
        viewModelScope.launch {
            userIntent.trySend(HomeIntent.InitialLoad)
        }
    }

    private fun performUserIntent() {
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect {
                if (it is HomeIntent) when (it) {
                    is HomeIntent.CharacterClick -> {
                        protectedSideEffect.trySend(HomeSideEffect.GoToCharacter(it.id))
                    }
                    is HomeIntent.LoadMore -> {
                        val state = state.value
                        if (state is HomeState.HomeUI) {
                            performInterpreter(nextPage.get())
                        }
                    }
                    is HomeIntent.InitialLoad -> {
                        performInterpreter(nextPage.get())
                    }
                }
            }
        }
    }

    private fun performInterpreter(page: Int) {
        viewModelScope.launch {
            val currentState = state.value
            if (currentState is HomeState.HomeError) {
                protectedState.emit(HomeState.HomeLoading)
            } else if (currentState is HomeState.HomeUI) {
                protectedState.emit(currentState.copy(isLoadingMore = true))
            }
            getCharacter(page).collect { entity ->
                when (entity) {
                    is Result.Success -> {
                        val currentState = state.value
                        nextPage.set(page+1)
                        when (currentState) {
                            is HomeState.HomeUI -> {
                                protectedState.emit(
                                    currentState.copy(
                                        CharacterListEntity(
                                            info = entity.data.info,
                                            results = currentState.entity.results + entity.data.results
                                        ),
                                        isLoadingMore = false,
                                        canLoadMore = nextPage.get() <= entity.data.info.pages,
                                        loadMoreError = null
                                    )
                                )
                            }
                            else -> {
                                protectedState.emit(
                                    HomeState.HomeUI(
                                        entity.data,
                                        canLoadMore = nextPage.get() <= entity.data.info.pages,
                                        loadMoreError = null
                                    )
                                )
                            }
                        }
                    }
                    is Result.Error -> {
                        if (currentState is HomeState.HomeLoading) {
                            protectedState.emit(HomeState.HomeError("Error loading..."))
                        } else if (currentState is HomeState.HomeUI) {
                            protectedState.emit(currentState.copy(isLoadingMore = false, loadMoreError = "Error loading..."))
                        }
                    }
                }
            }
        }
    }
}