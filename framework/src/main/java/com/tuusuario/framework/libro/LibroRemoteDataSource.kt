package com.tuusuario.framework.libro

import com.tuusuario.data.NetworkResult
import com.tuusuario.data.libro.IMovieRemoteDataSource
import com.tuusuario.domain.Libro
import com.tuusuario.framework.mappers.toModel
import com.tuusuario.framework.service.RetrofitBuilder

class MovieRemoteDataSource(
    val retrofiService: RetrofitBuilder
): IMovieRemoteDataSource {
    override suspend fun fetchPopularMovies(token: String): NetworkResult<List<Libro>> {
        val response = retrofiService.movieService.fetchPopularMovies(token)
        if (response.isSuccessful) {
            return NetworkResult.Success(response.body()!!.results.map { it.toModel() })
        } else {
            return NetworkResult.Error(response.message())
        }
    }
}