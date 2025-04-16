package com.tuusuario.data.push

interface IPushDataSource {
    suspend fun getToken(): String
}