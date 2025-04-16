package com.tuusuario.data.git

import com.tuusuario.domain.Gitalias

interface ILocalDataSource {
    suspend fun save(account: Gitalias): Boolean
    suspend fun findByUser(alias: String): Gitalias
}