package com.example.apiwithpaging3.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.apiwithpaging3.databinding.PersonItemBinding
import com.example.apiwithpaging3.models.Data
import com.example.apiwithpaging3.utils.Glide

class PersonAdapter :
    PagingDataAdapter<Data, PersonAdapter.PersonViewHolder>(PersonComparator) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): PersonViewHolder {
        return PersonViewHolder(
            PersonItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bindPerson()
    }

    inner class PersonViewHolder(private val binding: PersonItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindPerson() = with(binding) {
            val item = getItem(absoluteAdapterPosition)!!
            Glide().glide(item.avatar.toString(), imgPerson)
            tvEmail.text = item.email.toString()
            tvName.text = item.firstName.toString().plus(" ").plus(item.lastName.toString())
        }
    }

    object PersonComparator : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }
}