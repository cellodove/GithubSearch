package com.peter.data.model

import com.google.gson.annotations.SerializedName
import com.peter.domain.model.GithubRepo
import com.peter.domain.model.Item

data class GithubRepoRes (

    @SerializedName("total_count")
    private val _total_count : Int,

    @SerializedName("incomplete_results")
    private val _incomplete_results : Boolean,

    @SerializedName("items")
    private val _items : List<Item>

) : GithubRepo{
    override val item: List<Item>
        get() = _items
}
