package com.samples.hiltdemosession.feature_news_favourite.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.samples.hiltdemosession.databinding.ItemFavouriteBinding
import com.samples.hiltdemosession.feature_news_favourite.adapters.FavouritesRecyclerAdapter.ViewHolder.Companion.create
import com.samples.hiltdemosession.feature_news_favourite.models.FavouritePresenter


class FavouritesRecyclerAdapter :
    ListAdapter<FavouritePresenter, FavouritesRecyclerAdapter.ViewHolder>(FavouritesComparator()) {
    class FavouritesComparator : DiffUtil.ItemCallback<FavouritePresenter>() {
        override fun areItemsTheSame(
            oldItem: FavouritePresenter,
            newItem: FavouritePresenter
        ): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(
            oldItem: FavouritePresenter,
            newItem: FavouritePresenter
        ): Boolean {
            return oldItem == newItem
        }

    }

    class ViewHolder(private val binding: ItemFavouriteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(favourite: FavouritePresenter) {
            binding.favourite = favourite
            binding.executePendingBindings()

        }

        companion object {
            fun create(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemFavouriteBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return create(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)

    }

}