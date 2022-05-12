package com.github.harrypottercharacters.presentation

import androidx.recyclerview.widget.DiffUtil
import com.github.harrypottercharacters.api.HPCharacter

class DiffUtils : DiffUtil.ItemCallback<HPCharacter>() {
    override fun areItemsTheSame(oldItem: HPCharacter, newItem: HPCharacter): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: HPCharacter, newItem: HPCharacter): Boolean {
        return oldItem == newItem
    }

}