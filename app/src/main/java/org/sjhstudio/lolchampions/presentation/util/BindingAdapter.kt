package org.sjhstudio.lolchampions.presentation.util

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview
import org.sjhstudio.lolchampions.domain.model.Champion
import org.sjhstudio.lolchampions.presentation.base.UiState
import org.sjhstudio.lolchampions.presentation.base.successOrNull
import org.sjhstudio.lolchampions.presentation.ui.adapter.ChampionAdapter

/**
 * '*' 과 Any 차이
 * '*' : 구체적인 타입이 정해졌을때 사용가능 (val list = arrayListOf<*> (x))
 * Any : 언제든 모든 타입 대입가능
 */
@BindingAdapter("adapter")
fun RecyclerView.bindAdapter(adapter: RecyclerView.Adapter<*>) {
    this.adapter = adapter
}

@BindingAdapter("skinAdapter")
fun CarouselRecyclerview.bindSkinAdapter(adapter: RecyclerView.Adapter<*>) {
    this.adapter = adapter
    setInfinite(true)
    setAlpha(true)
    setIntervalRatio(0.9f)
    isNestedScrollingEnabled = false
}

@BindingAdapter("championItems")
fun RecyclerView.bindChampionItems(uiState: UiState<List<Champion>>) {
    val boundAdapter = adapter
    if (boundAdapter is ChampionAdapter) boundAdapter.submitList(uiState.successOrNull())
}

@BindingAdapter("itemDecoration")
fun RecyclerView.bindItemDecoration(decor: RecyclerView.ItemDecoration) {
    if (itemDecorationCount == 0) addItemDecoration(decor)
}

@BindingAdapter("showProgress")
fun ProgressBar.bindShowProgress(uiState: UiState<*>) {
    visibility = if (uiState is UiState.Loading) View.VISIBLE else View.GONE
}

@BindingAdapter("imageUrl")
fun ImageView.bindImageUrl(url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(context)
            .load(url)
            .into(this)
    }
}

@BindingAdapter(value = ["url", "onFinishedLoad"], requireAll = true)
fun ImageView.bindTransitionImageUrl(url: String?, onFinishedLoad: (() -> Unit)?) {
    if (!url.isNullOrEmpty() && onFinishedLoad != null) {
        val listener = object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                onFinishedLoad()
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                onFinishedLoad()
                return false
            }

        }
        Glide.with(context)
            .load(url)
            .listener(listener)
            .into(this)
    }
}

@BindingAdapter(value = ["championId", "skinNum"], requireAll = true)
fun ImageView.bindSkinImageUrl(championId: String?, skinNum: Int?) {
    if (championId != null && skinNum != null) {
        Glide.with(context)
            .load(getSkinImageUrl(championId, skinNum))
            .into(this)
    }
}