package com.peter.domain.usecase

import com.peter.domain.model.LocalGithubItem
import com.peter.domain.repository.GithubRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class DeleteLocalGithubReposUseCase(private val githubRepository : GithubRepository) {
    operator fun invoke(
        item : LocalGithubItem,
        scope : CoroutineScope,
        onResult : (Unit) -> Unit = {}
    ){
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO){
                githubRepository.deleteItem(item)
            }
            onResult(deferred.await())
        }
    }
}