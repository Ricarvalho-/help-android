package com.ricarvalho.help.home

import com.ricarvalho.help.R
import com.ricarvalho.help.common.ViewBindingViewHolder
import com.ricarvalho.help.databinding.ItemPostCardBinding as Binding

class ItemPostCardViewHolder(binding: Binding) : ViewBindingViewHolder<Binding, Post>(binding) {
    override fun Binding.onBind(item: Post): Unit = with(item) {
//        categoryImageView.setImageResource
        titleTextView.text = title
        locationTextView.text = location
        optionsButton.setOnClickListener {}
//        postImage.setImageResource
        descriptionTextView.text = description
//        ownerImageView.setImageResource
//        ownerImageView.setBackgroundResource
//        ownerTextView.text
//        dateTextView.text
        mock()
    }

    private fun Binding.mock() {
        categoryImageView.setImageResource(R.drawable.ic_round_eco_24)
        titleTextView.text = "Desmatamento de área preservada"
        locationTextView.text = "Serra da Cantareira"
        optionsButton.setOnClickListener {}
        postImage.setImageResource(R.color.design_default_color_primary_dark)
        descriptionTextView.text = "Muitas árvores nativas da região foram cortadas por conta da obra de condomínio de luxo ilegal.\n\nEssa obra que está no nome de Verena (laranja), esposa do Álvaro da Nobrega, que é o atual presidente da PWA, precisa ser embargada."
        ownerImageView.setImageResource(R.drawable.ic_launcher_foreground)
        ownerImageView.setBackgroundResource(R.drawable.ic_launcher_background)
        ownerTextView.text = "Davi Moretti"
        dateTextView.text = "23/10/20"
    }
}