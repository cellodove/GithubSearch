package com.peter.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item")
data class LocalGithubRepo (
    @PrimaryKey()
    val login : String,

    val url : String,

    val avatar_url : String,

    val html_url : String
)