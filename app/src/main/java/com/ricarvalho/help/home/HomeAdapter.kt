package com.ricarvalho.help.home

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ricarvalho.help.R
import com.ricarvalho.help.common.AsyncInflatingViewHolder as Async

class HomeAdapter : ListAdapter<String, Async<ItemPostCardViewHolder>>(
    object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            TODO("Not yet implemented")
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            TODO("Not yet implemented")
        }
    }
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Async<ItemPostCardViewHolder> = Async.binding(parent, R.layout.item_post_card)

    override fun onBindViewHolder(holder: Async<ItemPostCardViewHolder>, position: Int) =
        holder.whenInflated { bind("") }

    override fun getItemCount() = 0
}