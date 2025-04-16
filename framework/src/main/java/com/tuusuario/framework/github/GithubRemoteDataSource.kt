package com.tuusuario.framework.github

import com.tuusuario.data.NetworkResult
import com.tuusuario.data.git.IGitRemoteDataSource
import com.tuusuario.domain.Gitalias
import com.tuusuario.framework.mappers.toModel
import com.tuusuario.framework.service.RetrofitBuilder

class GithubRemoteDataSource(
    val retrofiService: RetrofitBuilder
) : IGitRemoteDataSource {
    override suspend fun fetch(userID: String): NetworkResult<Gitalias> {
        val response = retrofiService.apiService.getInfoAvatar(userID)
        if(response.isSuccessful) {
            return NetworkResult.Success(response.body()!!.toModel())
        } else {
            return NetworkResult.Error(response.message())
        }
    }
}