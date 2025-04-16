package com.tuusuario.data

import com.tuusuario.data.push.IPushDataSource

class PushNotificationRepository(
    val push: IPushDataSource
) {

    suspend fun getToken(): String {
        return push.getToken()
    }
}