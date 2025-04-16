package com.tuusuario.framework.mappers

import com.tuusuario.domain.Gitalias
import com.tuusuario.domain.Libro
import com.tuusuario.framework.dto.AvatarResponseDto
import com.tuusuario.framework.dto.MovieDto
import com.tuusuario.framework.persistence.GitAccount

fun AvatarResponseDto.toModel(): Gitalias {
    return Gitalias(
        login = login,
        avatarUrl = url
    )
}

fun Gitalias.toEntity(): GitAccount {
    return GitAccount(login)
}

fun GitAccount.toModel(): Gitalias {
    return Gitalias(
        alias,
        ""
    )
}

fun MovieDto.toModel(): Libro {
    return Libro(
        title = title,
        overview = overview,
        posterPath = posterPath
    )
}