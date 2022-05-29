package com.peter.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item")
data class LocalGithubRepo (
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,

    val login : String,

    val url : String,

    val avatar_url : String,

    val html_url : String
)