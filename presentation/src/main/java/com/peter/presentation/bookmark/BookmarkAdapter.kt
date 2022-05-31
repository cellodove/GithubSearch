package com.peter.presentation.bookmark

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.peter.data.model.ResLocalGithubRepo
import com.peter.presentation.databinding.BookmarkItemBinding

class BookmarkAdapter : RecyclerView.Adapter<BookmarkAdapter.ViewHolder>(){
    private val items = mutableListOf<ResLocalGithubRepo>()

    interface OnItemClickListener{
        fun onItemClick(item : ResLocalGithubRepo, isBookmark : Boolean)
    }
    private var listener : OnItemClickListener? = null
    fun setOnItemClickListener(listener : OnItemClickListener) {
        this.listener = listener
    }

    fun setItems(items: List<ResLocalGithubRepo>) {
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
        fun bind(repoRes : ResLocalGithubRepo){
            binding.repoName.text = repoRes.login
            binding.repoUrl.text = repoRes.url
            Glide.with(binding.root)
                .load(repoRes.avatar_url)
                .override(100,100)
                .into(binding.profileImage)

            binding.bookMark.setOnClickListener {
                if (binding.bookMark.isActivated){
                    listener?.onItemClick(repoRes,true)
                }else{
                    listener?.onItemClick(repoRes,false)
                }
            }
        }
    }
}