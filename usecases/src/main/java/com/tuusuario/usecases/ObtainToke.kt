package com.tuusuario.usecases

import com.tuusuario.data.PushNotificationRepository

class ObtainToken(
    val pushRepository: PushNotificationRepository
) {
    suspend fun getToken(): String {
        return this.pushRepository.getToken()
    }
}