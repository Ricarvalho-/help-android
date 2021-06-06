package com.ricarvalho.help.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ricarvalho.help.R
import com.ricarvalho.help.common.AsyncInflatingViewHolder as Async

class HomeAdapter : ListAdapter<Post, Async<ItemPostCardViewHolder>>(
    object : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Post, newItem: Post) = oldItem == newItem
    }
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Async<ItemPostCardViewHolder> = Async.binding(parent, R.layout.item_post_card)

    override fun onBindViewHolder(holder: Async<ItemPostCardViewHolder>, position: Int) =
        holder.whenInflated { bind(getItem(position)) }
}