package com.ricarvalho.help.home

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ricarvalho.help.R
import com.ricarvalho.help.common.ItemMarginDecoration
import com.ricarvalho.help.common.ViewBindingFragment
import com.ricarvalho.help.databinding.FragmentHomeBinding as Binding

class HomeFragment : ViewBindingFragment<Binding>(Binding::class.java) {
    override fun Binding.onCreated(savedInstanceState: Bundle?) {
        // TODO: Implement general chart
        recyclerView.setup()
        newPostFab.setup()
        bottomAppBar.setup()
    }

    private fun RecyclerView.setup() {
        setHasFixedSize(true)
        addItemDecoration(ItemMarginDecoration(R.dimen.post_card_margin))
        layoutManager = LinearLayoutManager(context)
        // TODO: Set Adapter
        adapter = HomeAdapter()
    }

    private fun FloatingActionButton.setup() = setOnClickListener {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToPostCreationFragment()
        )
    }

    private fun BottomAppBar.setup() {
        setNavigationOnClickListener {
            // TODO: Show account bottom sheet
        }
        setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.filter -> Unit // TODO: Open filter bottom sheet
                R.id.map -> Unit // TODO: Navigate to map
                else -> return@setOnMenuItemClickListener false
            }
            true
        }
    }
}