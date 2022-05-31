package com.peter.data

import com.peter.data.source.LocalGithubRemoteSource
import com.peter.domain.model.LocalGithubRepo
import com.peter.domain.repository.LocalGithubRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalRepositoryImpl @Inject constructor(private val localGithubRemoteSource: LocalGithubRemoteSource) : LocalGithubRepository {
    override fun saveItem(item: LocalGithubRepo) {
        localGithubRemoteSource.saveItem(item)
    }

    override fun getAllItem(): List<LocalGithubRepo> {
        return localGithubRemoteSource.getAllItem()
    }

    override fun deleteItem(item: LocalGithubRepo) {
        localGithubRemoteSource.deleteItem(item)
    }
}