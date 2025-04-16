package com.tuusuario.data.datasource

interface RemoteBookDataSource {

    suspend fun searchBooks(query: String): List<BookDto>
}