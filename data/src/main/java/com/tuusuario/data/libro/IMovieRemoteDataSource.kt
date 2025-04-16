package com.tuusuario.data.libro

import com.tuusuario.data.NetworkResult
import com.tuusuario.domain.Libro

interface IMovieRemoteDataSource {
    suspend fun fetchPopularMovies(token: String): NetworkResult<List<Libro>>
}