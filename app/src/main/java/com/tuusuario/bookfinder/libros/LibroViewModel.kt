package com.tuusuario.bookfinder.libros

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LibroViewModel @Inject constructor (private val getPopularMovies: GetPopularLibro): ViewModel() {

    sealed class MovieUIState {
        object Loading: MovieUIState()
        class Loaded(val list: List<Libro>): MovieUIState()
        class Error(val message: String): MovieUIState()
    }
    private val _state = MutableStateFlow<MovieUIState>(MovieUIState.Loading)
    val state : StateFlow<MovieUIState> = _state

    fun loadMovies() {
        _state.value = MovieUIState.Loading
        viewModelScope.launch {
            val response = getPopularMovies.invoke()
            when ( val result = response ) {
                is NetworkResult.Error -> {
                    _state.value = MovieUIState.Error(result.error)
                }
                is NetworkResult.Success -> {
                    _state.value = MovieUIState.Loaded(result.data)
                }
            }

        }

    }
}