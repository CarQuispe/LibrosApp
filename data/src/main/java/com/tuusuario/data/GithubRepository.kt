package com.tuusuario.data

import com.tuusuario.data.git.IGitRemoteDataSource
import com.tuusuario.data.git.ILocalDataSource
import com.tuusuario.domain.Gitalias

class GithubRepository (private val remoteDataSource: IGitRemoteDataSource,
                        private val localDataSource: ILocalDataSource
){

    suspend fun findbyId(userId: String): NetworkResult<Gitalias> {
        return this.remoteDataSource.fetch(userId)
    }

    suspend fun save(account: Gitalias): Boolean {
        this.localDataSource.save(account)
        return true
    }
}