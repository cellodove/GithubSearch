package com.peter.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.peter.domain.model.Item
import com.peter.domain.model.Bookmark
import com.peter.presentation.databinding.SearchItemBinding

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.ViewHolder>(){
    private val items = mutableListOf<Item>()
    private val bookmark = mutableListOf<Bookmark>()

    interface OnItemClickListener{
        fun onItemClick(item : Item, isBookmark : Boolean)
    }
    private var listener : OnItemClickListener? = null
    fun setOnItemClickListener(listener : OnItemClickListener) {
        this.listener = listener
    }

    fun setItems(items: List<Item>, bookmarks : List<Bookmark>) {
        this.items.clear()
        this.items.addAll(items)

        this.bookmark.clear()
        this.bookmark.addAll(bookmarks)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(SearchItemBinding.inflate(layoutInflater))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }


    inner class ViewHolder(private val binding: SearchItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(repo : Item){
            binding.repoName.text = repo.login
            binding.repoUrl.text = repo.url
            Glide.with(binding.root)
                .load(repo.avatar_url)
                .override(100,100)
                .into(binding.profileImage)


            bookmark.forEach {
                if (it.login == repo.login){
                    binding.bookMark.isActivated = true
                }
            }

            binding.bookMark.setOnClickListener {
                if (binding.bookMark.isActivated){
                    listener?.onItemClick(repo,true)
                }else{
                    listener?.onItemClick(repo,false)
                }
            }
        }
    }
}