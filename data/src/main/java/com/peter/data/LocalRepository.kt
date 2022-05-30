package com.peter.data

import com.peter.data.model.LocalGithubRepo
import com.peter.data.service.LocalDao
import com.peter.domain.model.Item
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalRepository @Inject constructor(private val localDao: LocalDao) {

    fun saveItem(item: LocalGithubRepo){
        localDao.insertItem(item)
    }

    fun getAllItem(): List<LocalGithubRepo>{
        return localDao.getAll()
    }

    fun deleteItem(item: LocalGithubRepo){
        localDao.deleteItem(item)
    }
}