package com.tuusuario.data.datastore

interface ILoginDataStore {
    suspend fun saveEmail(email: String)
    suspend fun getEmail(): Result<String>
}