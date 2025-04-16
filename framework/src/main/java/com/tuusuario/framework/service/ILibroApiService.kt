package com.tuusuario.framework.service
import com.tuusuario.framework.dto.MovieResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ILibroApiService {
    @GET("/3/discover/movie?sort_by=popularity.desc")
    suspend fun fetchPopularMovies(@Query("api_key") token: String): Response<MovieResponseDto>

}