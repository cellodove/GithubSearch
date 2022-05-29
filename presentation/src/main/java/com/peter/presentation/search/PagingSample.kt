package com.peter.presentation.search

import com.peter.domain.model.Item

data class PagingSample(
    val data: List<Item>,
    val page: Int
)