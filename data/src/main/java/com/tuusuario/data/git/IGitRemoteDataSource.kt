package com.tuusuario.data.git

import com.tuusuario.data.NetworkResult
import com.tuusuario.domain.Gitalias

interface IGitRemoteDataSource {
    suspend fun fetch(userID: String): NetworkResult<Gitalias>
}