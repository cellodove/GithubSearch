package com.peter.presentation.bookmark

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.peter.data.model.LocalGithubRepo
import com.peter.domain.model.GithubRepo
import com.peter.domain.model.Item
import com.peter.domain.model.LocalGithubItem
import com.peter.presentation.MainViewModel
import com.peter.presentation.databinding.BookmarkItemBinding
import com.peter.presentation.databinding.SearchItemBinding
import javax.inject.Inject

class BookmarkAdapter : RecyclerView.Adapter<BookmarkAdapter.ViewHolder>(){
    private val items = mutableListOf<LocalGithubItem>()

    interface OnItemClickListener{
        fun onItemClick(item : LocalGithubItem, isBookmark : Boolean)
    }
    private var listener : OnItemClickListener? = null
    fun setOnItemClickListener(listener : OnItemClickListener) {
        this.listener = listener
    }

    fun setItems(items: List<LocalGithubItem>) {
        this.items.clear()
        this.items.addAll(items)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(BookmarkItemBinding.inflate(layoutInflater))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }


    inner class ViewHolder(private val binding: BookmarkItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(repo : LocalGithubItem){
            binding.repoName.text = repo.login
            binding.repoUrl.text = repo.url
            Glide.with(binding.root)
                .load(repo.avatarUrl)
                .override(100,100)
                .into(binding.profileImage)

            binding.bookMark.setOnClickListener {
                listener?.onItemClick(repo,true)
            }
        }
    }
}