package com.ricarvalho.help.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ricarvalho.help.R
import com.ricarvalho.help.databinding.ItemPostCardBinding

class HomeAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            object : RecyclerView.ViewHolder(
                    ItemPostCardBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                    ).apply {
                        mock()
                    }.root
            ) {}

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = Unit
    override fun getItemCount() = 10

    private fun ItemPostCardBinding.mock() {
        kindImageView.setImageResource(R.drawable.ic_round_eco_24)
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