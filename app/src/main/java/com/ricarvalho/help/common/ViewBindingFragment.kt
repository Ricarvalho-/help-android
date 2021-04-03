package com.ricarvalho.help.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.Exception

abstract class ViewBindingFragment<B : ViewBinding>(private val bindingClass: Class<B>) : Fragment() {
    protected var binding: B? = null

    protected open fun B.onCreated(savedInstanceState: Bundle?) = Unit
    protected open fun B.onDestroy() = Unit

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ) = inflateBinding(inflater, container).also { binding = it }.root

    private fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?) = try {
        bindingClass.cast(bindingClass.getDeclaredMethod(
                "inflate",
                LayoutInflater::class.java,
                ViewGroup::class.java,
                Boolean::class.java
        ).invoke(null, inflater, container, false))
    } catch (exception: Exception) {
        throw exception.cause ?: exception
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.onCreated(savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding?.onDestroy()
        binding = null
    }
}