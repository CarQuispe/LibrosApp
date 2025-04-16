package com.tuusuario.usecases

import com.tuusuario.data.LoginRepository
import kotlinx.coroutines.delay

class DoLogin(
    private val loginRepository: LoginRepository
) {
    suspend fun invoke(userName: String, password: String) : Result<Unit> {
        delay(1)
        return loginRepository.doLogin(userName, password)
    }
}