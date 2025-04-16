package com.tuusuario.framework.github

import android.content.Context
import com.tuusuario.data.git.ILocalDataSource
import com.tuusuario.domain.Gitalias
import com.tuusuario.framework.mappers.toEntity
import com.tuusuario.framework.persistence.AppRoomDatabase
import com.tuusuario.framework.persistence.IGitAccountDAO
import  com.tuusuario.framework.mappers.toModel

class GithubLocalDataSource(val context: Context) : ILocalDataSource {
    val githubDAO: IGitAccountDAO = AppRoomDatabase.getDatabase(context).githubDao()
    override suspend fun save(account: Gitalias): Boolean {
        githubDAO.insert(account.toEntity())
        return true
    }

    override suspend fun findByUser(alias: String): Gitalias {
        return githubDAO.findByAlias(alias).toModel()
    }
}