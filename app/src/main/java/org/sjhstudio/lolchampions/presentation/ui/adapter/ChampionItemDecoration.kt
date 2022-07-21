package org.sjhstudio.lolchampions.presentation.ui.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import org.sjhstudio.lolchampions.presentation.util.dpToPx

class ChampionItemDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val spacePx = view.context.dpToPx(BETWEEN_SPACE) / 2
        if(parent.getChildAdapterPosition(view) % 2 != 0) {
            outRect.left = spacePx
        } else {
            outRect.right = spacePx
        }
    }

    companion object {
        private const val BETWEEN_SPACE = 15F
    }
}