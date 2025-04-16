package com.tuusuario.usecases

import com.tuusuario.data.GithubRepository
import com.tuusuario.data.NetworkResult
import com.tuusuario.domain.Gitalias

class FindGitAlias(
    val githubRepository: GithubRepository
) {
    suspend fun invoke(userId: String) : NetworkResult<Gitalias> {
//        delay(100)
        //      return Gitalias("calyr", "https://avatars.githubusercontent.com/u/874321?v=4")
        return githubRepository.findbyId(userId)
    }
}