package com.github.harrypottercharacters.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.github.harrypottercharacters.api.HPCharacter
import com.github.harrypottercharacters.databinding.RvItemBinding

class HPCharAdapter : RecyclerView.Adapter<HPCharAdapter.HPCharViewHolder>() {

    var characters: List<HPCharacter>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    inner class HPCharViewHolder(
        val binding: RvItemBinding
    ) : RecyclerView.ViewHolder(binding.root)

    private val differ = AsyncListDiffer(this, DiffUtils())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HPCharViewHolder {
        return HPCharViewHolder(
            RvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HPCharViewHolder, position: Int) {
        holder.binding.apply {
            val character = characters[position]
            tvName.text = character.name
        }
    }

    override fun getItemCount(): Int = characters.size
}