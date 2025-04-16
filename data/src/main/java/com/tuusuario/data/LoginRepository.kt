package com.tuusuario.data

import com.tuusuario.data.datastore.ILoginDataStore

class LoginRepository(private val store: ILoginDataStore) {

    suspend fun doLogin(user: String, password: String) : Result<Unit> {
        //realiar el login

        //
        store.saveEmail("calyr.software@gmail.com")
        return Result.success(Unit)
    }

    suspend fun getEmail(): Result<String> {
        return store.getEmail()
    }
}