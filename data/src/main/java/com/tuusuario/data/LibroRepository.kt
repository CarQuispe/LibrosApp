package com.tuusuario.data

import com.tuusuario.data.libro.IMovieRemoteDataSource
import com.tuusuario.domain.Libro

class LibroRepository(
    val remoteDataSource: IMovieRemoteDataSource
) {

    suspend fun getPopularMovies(token: String): NetworkResult<List<Libro>> {
        return this.remoteDataSource.fetchPopularMovies(token)
    }
}