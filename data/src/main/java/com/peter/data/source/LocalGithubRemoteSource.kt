package com.peter.data.source

import com.peter.data.model.LocalGithubRepo
import com.peter.data.service.LocalDao
import javax.inject.Inject


interface LocalGithubRemoteSource {
    suspend fun getAll() : List<LocalGithubRepo>

    suspend fun insertItem(item: LocalGithubRepo)

    suspend fun deleteItem(item: LocalGithubRepo)
}

class LocalGithubRemoteSourceImpl @Inject constructor(
    private val localDao: LocalDao
) : LocalGithubRemoteSource{

    override suspend fun getAll(): List<LocalGithubRepo> {
        return localDao.getAll()
    }

    override suspend fun insertItem(item: LocalGithubRepo) {
        localDao.insertItem(item)
    }

    override suspend fun deleteItem(item: LocalGithubRepo) {
        localDao.deleteItem(item)
    }
}
