package com.peter.presentation.search

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PagingRepository @Inject constructor(
    private val service: SampleBackendService
) {

    fun getPagingData(): Flow<PagingData<String>> {
        return Pager(PagingConfig(pageSize = 10)) {
            SearchPagingSource(service)
        }.flow
    }
}