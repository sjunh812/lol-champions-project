package org.sjhstudio.lolchampions.presentation.ui.adapter

import android.os.SystemClock
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sjhstudio.lolchampions.databinding.ItemChampionBinding
import org.sjhstudio.lolchampions.domain.model.Champion

class ChampionAdapter(
    private val onClickedItem: (Champion, Pair<View, String>) -> Unit
) : ListAdapter<Champion, ChampionAdapter.ChampionViewHolder>(diffCallback) {
    private var lastClickTime: Long = 0L

    inner class ChampionViewHolder(private val binding: ItemChampionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            with(binding) {
                root.setOnClickListener {
                    if (SystemClock.elapsedRealtime() - lastClickTime > 1000) {
                        val position = adapterPosition.takeIf { it != RecyclerView.NO_POSITION }
                            ?: return@setOnClickListener
                        onClickedItem(
                            getItem(position),
                            Pair(ivChampion, ivChampion.transitionName)
                        )
                    }
                    lastClickTime = SystemClock.elapsedRealtime()
                }
            }
        }

        fun bind(data: Champion) {
            with(binding) {
                champion = data
                executePendingBindings()    // 안드로이드 프레임워크에 date 변경을 알림
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