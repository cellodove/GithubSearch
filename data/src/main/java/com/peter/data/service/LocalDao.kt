package com.peter.data.service

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.peter.data.model.LocalGithubRepo
import com.peter.domain.model.Item


@Dao
interface LocalDao {
    @Query("SELECT * FROM item ORDER BY id DESC")
    fun getAll() : List<LocalGithubRepo>

    @Insert
    fun insertItem(item: Item)

    @Delete
    fun deleteItem(item: Item)
}