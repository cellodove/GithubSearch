package com.peter.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.peter.domain.model.GithubRepo
import com.peter.domain.model.Item
import com.peter.presentation.databinding.SearchItemBinding

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.ViewHolder>(){
    private val items = mutableListOf<Item>()

    interface OnItemClickListener{
        fun onItemClick(item : Item)
    }
    private var listener : OnItemClickListener? = null
    fun setOnItemClickListener(listener : OnItemClickListener) {
        this.listener = listener
    }

    fun setItems(items: List<Item>) {
        this.items.clear()
        this.items.addAll(items)

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

            binding.bookMark.setOnClickListener {
                if (binding.bookMark.isActivated){

                }else{

                }
                listener?.onItemClick(repo)
            }
        }
    }
}