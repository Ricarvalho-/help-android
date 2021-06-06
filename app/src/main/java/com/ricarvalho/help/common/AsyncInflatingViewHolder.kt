package com.ricarvalho.help.common

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.LayoutRes
import androidx.asynclayoutinflater.view.AsyncLayoutInflater
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class AsyncInflatingViewHolder<VH: RecyclerView.ViewHolder>(
    parent: ViewGroup,
    @LayoutRes layout: Int,
    asyncContainer: ViewGroup = FrameLayout(parent.context),
    viewHolderProvider: (itemView: View) -> VH
) : RecyclerView.ViewHolder(asyncContainer) {
    companion object {
        inline fun <VH: RecyclerView.ViewHolder, reified B: ViewBinding> binding(
            parent: ViewGroup,
            @LayoutRes layout: Int,
            asyncContainer: ViewGroup = FrameLayout(parent.context),
            crossinline viewHolderProvider: (binding: B) -> VH
        ) = AsyncInflatingViewHolder(parent, layout, asyncContainer) {
            val binding = try {
                B::class.java.getMethod("bind", View::class.java).invoke(null, it) as B
            } catch (exception: Exception) {
                throw exception.cause ?: exception
            }
            viewHolderProvider(binding)
        }

        inline fun <reified VH: ViewBindingViewHolder<B, I>, reified B, I> binding(
            parent: ViewGroup,
            @LayoutRes layout: Int,
            asyncContainer: ViewGroup = FrameLayout(parent.context)
        ) = AsyncInflatingViewHolder(parent, layout, asyncContainer) {
            try {
                val binding = B::class.java.getMethod("bind", View::class.java)
                    .invoke(null, it) as B
                VH::class.java.getConstructor(B::class.java).newInstance(binding)
            } catch (exception: Exception) {
                throw exception.cause ?: exception
            }
        }
    }

    private lateinit var viewHolder: VH
    private val delayedOperations = mutableListOf<VH.() -> Unit>()

    init {
        AsyncLayoutInflater(parent.context).inflate(layout, asyncContainer) { view, _, _ ->
            asyncContainer.addView(view)
            viewHolder = viewHolderProvider(view)
            delayedOperations.onEach { it(viewHolder) }.clear()
        }
    }

    fun whenInflated(operation: VH.() -> Unit) {
        if (this::viewHolder.isInitialized) operation(viewHolder)
        else delayedOperations += operation
    }
}