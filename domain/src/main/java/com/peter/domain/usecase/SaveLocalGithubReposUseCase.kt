package com.peter.domain.usecase

import com.peter.domain.model.Bookmark
import com.peter.domain.repository.LocalGithubRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class SaveLocalGithubReposUseCase(private val localGithubRepository : LocalGithubRepository) {
    operator fun invoke(
        item : Bookmark,
        scope : CoroutineScope,
        onResult : (Unit) -> Unit = {}
    ){
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO){
                localGithubRepository.saveItem(item)
            }
            onResult(deferred.await())
        }
    }
}