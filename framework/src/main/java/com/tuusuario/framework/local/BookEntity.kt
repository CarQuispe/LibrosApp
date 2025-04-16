package com.tuusuario.framework.entity

import com.tuusuario.domain.Book

fun BookEntity.toBook(): Book = Book(
    id = this.id,
    title = this.title,
    authorName = this.authorNames,
    firstPublishYear = this.firstPublishYear,
    coverId = this.coverId
)

fun Book.toEntity(): BookEntity = BookEntity(
    id = this.id,
    title = this.title,
    authorNames = this.authorName,
    firstPublishYear = this.firstPublishYear,
    coverId = this.coverId,
    //authorNames = TODO()
)
