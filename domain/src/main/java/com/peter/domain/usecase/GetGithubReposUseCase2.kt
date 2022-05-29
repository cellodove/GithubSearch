package com.peter.domain.usecase

import com.peter.domain.model.GithubRepo
import com.peter.domain.repository.GithubRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class GetGithubReposUseCase2(private val githubRepository : GithubRepository) {
    operator fun invoke(
        owner : String,
        page : Int,
        scope : CoroutineScope,
        onResult : (GithubRepo) -> Unit = {}
    ){
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO){
                githubRepository.getRepos(owner,page)
            }
            onResult(deferred.await())
        }
    }
}