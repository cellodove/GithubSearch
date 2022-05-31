package com.peter.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.peter.domain.model.LocalGithubRepo

@Entity(tableName = "item")
data class LocalGithubRepoRes(
    @PrimaryKey
    @ColumnInfo(name = "login")
    val login : String,

    @ColumnInfo(name = "url")
    val url : String,

    @ColumnInfo(name = "avatarUrl")
    val avatarUrl : String,

    @ColumnInfo(name = "htmlUrl")
    val htmlUrl : String,

    @ColumnInfo(name = "isBookmark")
    val isBookmark : Boolean
)