package com.peter.domain.usecase

import com.peter.domain.model.LocalGithubItem
import com.peter.domain.repository.GithubRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class SaveLocalGithubReposUseCase(private val githubRepository : GithubRepository) {
    operator fun invoke(
        item : LocalGithubItem,
        scope : CoroutineScope,
        onResult : (Unit) -> Unit = {}
    ){
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO){
                githubRepository.insertItem(item)
            }
            onResult(deferred.await())
        }
    }
}