package com.lucas.moviesnow.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.moviesnow.data.service.MoviesNowService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class MoviesNowViewModel(private val moviesNowService: MoviesNowService) : ViewModel(), KoinComponent {
    private val _state = MutableStateFlow(MovieNowState())
    val state: StateFlow<MovieNowState> = _state.asStateFlow()

    init { loadMovies() }

    fun loadMovies() {
        viewModelScope.launch {
            moviesNowService.getMovies().onSuccess { movies ->
                _state.value = _state.value.copy(result = MovieNowStateResult.Success(movies))
            }.onFailure { exception ->
                _state.value = _state.value.copy(
                    result = MovieNowStateResult.Failed(
                        exception.message ?: "Infelizmente o erro não foi identificado"
                    )
                )
            }
        }
    }
}