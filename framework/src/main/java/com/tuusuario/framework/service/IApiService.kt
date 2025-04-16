package com.tuusuario.framework.service

import com.tuusuario.framework.dto.AvatarResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IApiService {
    @GET("/users/{githubLogin}")
    suspend fun getInfoAvatar(@Path("githubLogin") githubLogin: String): Response<AvatarResponseDto>
}
