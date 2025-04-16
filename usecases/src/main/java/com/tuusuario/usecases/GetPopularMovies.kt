package com.tuusuario.usecases

import com.tuusuario.data.LibroRepository
import com.tuusuario.data.NetworkResult
import com.tuusuario.domain.Libro

class GetPopularMovies(
    val movieRepository: LibroRepository,
    val token: String
) {
    suspend fun invoke(): NetworkResult<List<Libro>> {
        return movieRepository.getPopularMovies(token = this.token)
    }
}