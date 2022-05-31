package com.peter.data

import com.peter.data.service.LocalDao
import com.peter.domain.model.Bookmark
import com.peter.domain.repository.LocalGithubRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalRepositoryImpl @Inject constructor(private val localDao: LocalDao) : LocalGithubRepository {
    override fun saveItem(item: Bookmark) {
        localDao.insertItem(item)
    }

    override fun getAllItem(): List<Bookmark> {
        return localDao.getAll()
    }

    override fun deleteItem(item: Bookmark) {
        localDao.deleteItem(item)
    }
}