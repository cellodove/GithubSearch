package com.peter.data

import com.peter.data.model.LocalGithubRepoRes
import com.peter.domain.model.LocalGithubRepo

fun LocalGithubRepo.fromDomain() : LocalGithubRepoRes{
    return LocalGithubRepoRes(
        login,url,avatarUrl,htmlUrl,isBookmark
    )
}



fun LocalGithubRepo.toDomain() : LocalGithubRepo{
    return LocalGithubRepo(
        login,url,avatarUrl,htmlUrl,isBookmark
    )
}

fun List<LocalGithubRepo>.fromDomain() : List<LocalGithubRepoRes>{
    return listOf()
}