package com.ricarvalho.help.common

import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView

class ItemMarginDecoration(@DimenRes private val itemMargin: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val margin = parent.resources.getDimensionPixelSize(itemMargin)
        val isFirstItem = parent.getChildAdapterPosition(view) == 0

        outRect.apply {
            if (isFirstItem) top = margin
            left =  margin
            right = margin
            bottom = margin
        }
    }
}