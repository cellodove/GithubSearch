package com.peter.data

import com.peter.data.service.LocalDao
import com.peter.domain.model.Item
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalRepository @Inject constructor(private val localDao: LocalDao) {

    fun saveItem(item: Item){
        localDao.insertItem(item)
    }

    fun getAllItem(){
        localDao.getAll()
    }

    fun deleteItem(item: Item){
        localDao.deleteItem(item)
    }
}