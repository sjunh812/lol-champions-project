package org.sjhstudio.lolchampions.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sjhstudio.lolchampions.databinding.ItemChampionBinding
import org.sjhstudio.lolchampions.domain.model.Champion

class ChampionAdapter : ListAdapter<Champion, ChampionAdapter.ChampionViewHolder>(diffCallback) {
    inner class ChampionViewHolder(private val binding: ItemChampionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Champion) {
            binding.apply {
                champion = data
                executePendingBindings()    // 안드로이드 프레임워크에 data 변경을 알림
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionViewHolder {
        val binding =
            ItemChampionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChampionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChampionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Champion>() {
            override fun areItemsTheSame(oldItem: Champion, newItem: Champion): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Champion, newItem: Champion): Boolean =
                oldItem == newItem
        }
    }
}