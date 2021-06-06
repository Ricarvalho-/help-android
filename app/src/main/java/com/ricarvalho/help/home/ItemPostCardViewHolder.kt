package com.ricarvalho.help.home

import com.ricarvalho.help.common.ViewBindingViewHolder
import com.ricarvalho.help.databinding.ItemPostCardBinding as Binding

class ItemPostCardViewHolder(binding: Binding) : ViewBindingViewHolder<Binding, String>(binding) {
    override fun Binding.onBind(item: String) = Unit
}