package com.peter.domain.model

data class LocalGithubRepo (
    val login: String,

    val url: String,

    val avatarUrl: String,

    val htmlUrl: String,

    val isBookmark: Boolean
)