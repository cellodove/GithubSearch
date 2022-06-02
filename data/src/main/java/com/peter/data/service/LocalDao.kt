package com.peter.data.service

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.peter.data.model.LocalGithubRepo

@Dao
interface LocalDao {
    @Query("SELECT * FROM item ORDER BY login DESC")
    fun getAll() : List<LocalGithubRepo>

    @Insert
    fun insertItem(item: LocalGithubRepo)

    @Delete
    fun deleteItem(item: LocalGithubRepo)
}