package com.ricarvalho.help.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class ViewBindingViewHolder<B : ViewBinding, I>(
    protected var binding: B
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        inline fun <reified B> inflateBinding(parent: ViewGroup, bindingClass: Class<B>) = try {
            bindingClass.getDeclaredMethod(
                "inflate",
                LayoutInflater::class.java,
                ViewGroup::class.java,
                Boolean::class.java
            ).invoke(null, LayoutInflater.from(parent.context), parent, false) as B
        } catch (exception: Exception) {
            throw exception.cause ?: exception
        }

        inline fun <reified V : ViewBindingViewHolder<B, *>, reified B> createFrom(
            parent: ViewGroup
        ): V = try {
            V::class.java.getConstructor(B::class.java)
                .newInstance(inflateBinding(parent, B::class.java))
        } catch (exception: Exception) {
            throw exception.cause ?: exception
        }
    }

    fun bind(item: I) = binding.onBind(item)

    protected open fun B.onBind(item: I) = Unit
}