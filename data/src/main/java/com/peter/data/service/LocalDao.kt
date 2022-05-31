package com.peter.data.service

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.peter.data.model.LocalGithubRepoRes

@Dao
interface LocalDao {
    @Query("SELECT * FROM item ORDER BY login DESC")
    fun getAll() : List<LocalGithubRepoRes>

    @Insert
    fun insertItem(item: LocalGithubRepoRes)

    @Delete
    fun deleteItem(item: LocalGithubRepoRes)
}