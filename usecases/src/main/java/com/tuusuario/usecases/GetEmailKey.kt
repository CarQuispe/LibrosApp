package com.tuusuario.usecases

import com.tuusuario.data.LoginRepository

class GetEmailKey(
    val loginRepository: LoginRepository
) {
    suspend fun invoke(): Result<String> {
        return loginRepository.getEmail()
    }
}
