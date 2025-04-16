package com.tuusuario.usecases

import com.tuusuario.data.GithubRepository
import com.tuusuario.domain.Gitalias

class SaveGitalias(
    val repository: GithubRepository
) {
    suspend fun invoke(account: Gitalias) {
        repository.save(account)
    }
}