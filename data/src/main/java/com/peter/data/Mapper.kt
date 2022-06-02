package com.peter.data

import com.peter.data.model.LocalGithubRepo
import com.peter.domain.model.LocalGithubItem

fun mapperToLocalGithubRepo(localItem : List<LocalGithubItem>):List<LocalGithubRepo>{
    return localItem.toList().map {
        LocalGithubRepo(
            it.id,
            it.login,
            it.url,
            it.avatarUrl,
            it.htmlUrl
        )
    }
}

fun LocalGithubItem.map() = LocalGithubRepo(
    id,
    login,
    url,
    avatarUrl,
    htmlUrl
)


fun mapperToLocalGithubItem(localRepo : List<LocalGithubRepo>) : List<LocalGithubItem>{
    return localRepo.toList().map {
        LocalGithubItem(
            it.id,
            it.login,
            it.url,
            it.avatar_url,
            it.html_url
        )
    }
}

fun LocalGithubRepo.map() = LocalGithubItem(
    id,
    login,
    url,
    avatar_url,
    html_url
)