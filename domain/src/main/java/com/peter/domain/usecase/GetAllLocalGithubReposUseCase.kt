package com.peter.domain.usecase

import com.peter.domain.model.Bookmark
import com.peter.domain.repository.LocalGithubRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class GetAllLocalGithubReposUseCase(private val localGithubRepository : LocalGithubRepository) {
    operator fun invoke(
        scope : CoroutineScope,
        onResult : (List<Bookmark>) -> Unit = {}
    ){
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO){
                localGithubRepository.getAllItem()
            }
            onResult(deferred.await())
        }
    }
}