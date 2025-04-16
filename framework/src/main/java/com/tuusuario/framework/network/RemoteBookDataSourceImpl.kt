package com.tuusuario.framework.network

import com.tuusuario.data.datasource.BookDto
import com.tuusuario.data.datasource.RemoteBookDataSource

class RemoteBookDataSourceImpl(
    private val apiService: BookApiService
) : RemoteBookDataSource {
    override suspend fun searchBooks(query: String): List<BookDto> {
        return apiService.searchBooks(query).docs
    }
}