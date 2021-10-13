package com.samples.hiltdemosession.ui.headlines

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.samples.hiltdemosession.databinding.ItemNewsBinding
import com.samples.hiltdemosession.models.NewsPresenter
import com.samples.hiltdemosession.ui.headlines.HeadlinesRecyclerAdapter.ViewHolder.Companion.create

class HeadlinesRecyclerAdapter : ListAdapter<NewsPresenter, HeadlinesRecyclerAdapter.ViewHolder>(HeadlinesComparator()) {

    class HeadlinesComparator  : DiffUtil.ItemCallback<NewsPresenter>() {
        override fun areItemsTheSame(oldItem: NewsPresenter, newItem: NewsPresenter): Boolean {
           return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: NewsPresenter, newItem: NewsPresenter): Boolean {
            return newItem == oldItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return create(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newsItem = getItem(position)
        holder.bind(newsItem)
    }

    class ViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(newsItem: NewsPresenter?) {
            binding.news = newsItem
            binding.executePendingBindings()
        }

        companion object {
            fun create(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemNewsBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }

    }


}
