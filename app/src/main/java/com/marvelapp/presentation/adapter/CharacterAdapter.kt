package com.marvelapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.marvelapp.R
import com.marvelapp.data.CharacterEntity
import com.marvelapp.databinding.ItemCharacterBinding

class CharacterAdapter(private val characters: List<CharacterEntity>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder =
        CharacterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        )

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int = characters.size

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: CharacterEntity) {
            ItemCharacterBinding.bind(itemView).apply {
                Glide.with(itemView.context)
                    .applyDefaultRequestOptions(
                        RequestOptions().placeholder(R.drawable.file_not_found)
                            .error(R.drawable.file_not_found)
                    )
                    .load(item.image)
                    .into(characterImage)
                characterName.text = item.name
            }
        }
    }
}
