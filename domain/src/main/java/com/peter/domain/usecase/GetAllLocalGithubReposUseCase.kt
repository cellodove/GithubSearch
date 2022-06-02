package com.peter.domain.usecase

import com.peter.domain.model.LocalGithubItem
import com.peter.domain.repository.GithubRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class GetAllLocalGithubReposUseCase(private val githubRepository : GithubRepository) {
    operator fun invoke(
        scope : CoroutineScope,
        onResult : (List<LocalGithubItem>) -> Unit = {}
    ){
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO){
                githubRepository.getAll()
            }
            onResult(deferred.await())
        }
    }
}