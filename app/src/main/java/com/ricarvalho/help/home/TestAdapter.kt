package com.ricarvalho.help.home

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ricarvalho.help.R
import com.ricarvalho.help.common.ViewBindingViewHolder
import com.ricarvalho.help.common.ViewBindingViewHolder.Companion.createFrom
import com.ricarvalho.help.databinding.ItemPostCardBinding
import com.ricarvalho.help.common.AsyncInflatingViewHolder as Async

class TestAdapter : RecyclerView.Adapter<TestAdapter.ViewHolder<out RecyclerView.ViewHolder>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            0 -> ViewHolder.ItemPostCard(parent)
            1 -> ViewHolder.ItemOther(parent)
            2 -> ViewHolder.ItemOtherOne(parent)
            else -> ViewHolder.ItemAnother(parent)
        }

    override fun onBindViewHolder(holder: ViewHolder<out RecyclerView.ViewHolder>, position: Int) =
        when (holder) {
            is ViewHolder.ItemPostCard -> holder.viewHolder.whenInflated { bind("") }
            is ViewHolder.ItemOther -> holder.viewHolder.whenInflated { bind(true) }
            is ViewHolder.ItemOtherOne -> holder.viewHolder.whenInflated { bind(0F) }
            is ViewHolder.ItemAnother -> holder.viewHolder.bind(0)
        }

    override fun getItemCount() = 0

    sealed class ViewHolder<VH: RecyclerView.ViewHolder>(
        val viewHolder: VH
    ) : RecyclerView.ViewHolder(viewHolder.itemView) {
        class ItemPostCard(parent: ViewGroup) : ViewHolder<Async<ItemPostCardViewHolder>>(
            Async.binding(parent, R.layout.item_post_card) { it: ItemPostCardBinding ->
                ItemPostCardViewHolder(it)
            }
        )

        class ItemOther(parent: ViewGroup) : ViewHolder<Async<ItemOtherViewHolder>>(
            Async(parent, R.layout.item_post_card) {
                ItemOtherViewHolder(ItemPostCardBinding.bind(it))
            }
        )

        class ItemOtherOne(parent: ViewGroup) : ViewHolder<Async<ItemOtherOneViewHolder>>(
            Async.binding(parent, R.layout.item_post_card)
        )

        class ItemAnother(parent: ViewGroup) : ViewHolder<ItemAnotherViewHolder>(createFrom(parent))
    }

    class ItemOtherViewHolder(
        binding: ItemPostCardBinding
    ) : ViewBindingViewHolder<ItemPostCardBinding, Boolean>(binding) {
        override fun ItemPostCardBinding.onBind(item: Boolean) = Unit
    }

    class ItemOtherOneViewHolder(
        binding: ItemPostCardBinding
    ) : ViewBindingViewHolder<ItemPostCardBinding, Float>(binding) {
        override fun ItemPostCardBinding.onBind(item: Float) = Unit
    }

    class ItemAnotherViewHolder(
        binding: ItemPostCardBinding
    ) : ViewBindingViewHolder<ItemPostCardBinding, Int>(binding) {
        override fun ItemPostCardBinding.onBind(item: Int) = Unit
    }
}