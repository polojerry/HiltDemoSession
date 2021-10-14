package com.samples.hiltdemosession.ui.headlines

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.samples.hiltdemosession.databinding.ItemNewsBinding
import com.samples.hiltdemosession.databinding.ItemNewsHeaderBinding
import com.samples.hiltdemosession.models.NewsPresenter
import com.samples.hiltdemosession.ui.headlines.HeadlinesRecyclerAdapter.HeadlinesHeaderViewHolder.Companion.createHeader
import com.samples.hiltdemosession.ui.headlines.HeadlinesRecyclerAdapter.NewsViewHolder.Companion.create

class HeadlinesRecyclerAdapter :
    ListAdapter<NewsPresenter, RecyclerView.ViewHolder>(HeadlinesComparator()) {

    class HeadlinesComparator : DiffUtil.ItemCallback<NewsPresenter>() {
        override fun areItemsTheSame(oldItem: NewsPresenter, newItem: NewsPresenter): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: NewsPresenter, newItem: NewsPresenter): Boolean {
            return newItem == oldItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER_ITEM -> {
                createHeader(parent)
            }
            NORMAL_ITEM -> {
                create(parent)
            }
            else -> throw ClassCastException("Unknown viewType $viewType")
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NewsViewHolder -> {
                val newsItem = getItem(position)
                holder.bind(newsItem)
            }

            is HeadlinesHeaderViewHolder -> {
                val newsItem = getItem(position)
                holder.bind(newsItem)
            }
        }
    }

    class NewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(newsItem: NewsPresenter?) {
            binding.news = newsItem
            binding.executePendingBindings()
        }

        companion object {
            fun create(parent: ViewGroup): NewsViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemNewsBinding.inflate(layoutInflater, parent, false)

                return NewsViewHolder(binding)
            }
        }
    }

    class HeadlinesHeaderViewHolder(private val binding: ItemNewsHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(newsItem: NewsPresenter?) {
            binding.news = newsItem
            binding.executePendingBindings()
        }

        companion object {
            fun createHeader(parent: ViewGroup): HeadlinesHeaderViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemNewsHeaderBinding.inflate(layoutInflater, parent, false)

                return HeadlinesHeaderViewHolder(binding)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> HEADER_ITEM
            else -> NORMAL_ITEM
        }
    }

    companion object {
        private val HEADER_ITEM = 0
        private val NORMAL_ITEM = 1
    }


}
