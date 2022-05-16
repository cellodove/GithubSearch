package com.peter.domain.usecase

import com.peter.domain.model.GithubRepo
import com.peter.domain.repository.GithubRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import sun.rmi.server.Dispatcher

class GetGithubReposUseCase(private val githubRepository : GithubRepository) {
    operator fun invoke(
        owner : String,
        scope : CoroutineScope,
        onResult : (List<GithubRepo>) -> Unit = {}
    ){
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO){
                githubRepository.getRepository(owner)
            }
            onResult(deferred.await())
        }
    }
}