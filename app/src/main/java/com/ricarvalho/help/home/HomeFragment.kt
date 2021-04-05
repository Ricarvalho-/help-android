package com.ricarvalho.help.home

import android.os.Bundle
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.transition.MaterialElevationScale
import com.ricarvalho.help.R
import com.ricarvalho.help.common.ItemMarginDecoration
import com.ricarvalho.help.common.ViewBindingFragment
import com.ricarvalho.help.common.addOnTabSelectedListener
import com.ricarvalho.help.databinding.FragmentHomeBinding

class HomeFragment : ViewBindingFragment<FragmentHomeBinding>(FragmentHomeBinding::class.java) {
    init {
        exitTransition = MaterialElevationScale(false)
        reenterTransition = MaterialElevationScale(true)
    }

    override fun FragmentHomeBinding.onCreated(savedInstanceState: Bundle?) {
        // TODO: Implement general chart
        tabLayout.setup()
        recyclerView.setup()
        newPostFab.setup()
        bottomAppBar.setup()
    }

    private fun TabLayout.setup() = addOnTabSelectedListener {
        // TODO: Filter list based on tab (it?.position)
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
                HomeFragmentDirections.actionHomeFragmentToPostDetailsFragment(),
                FragmentNavigatorExtras(it to getString(R.string.new_post_transition))
        )
    }

    private fun BottomAppBar.setup() {
        setNavigationOnClickListener {
            // TODO: Show bottom sheet
        }
        setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.map -> Unit // TODO: Open map
                R.id.search -> Unit // TODO: Perform search
                else -> return@setOnMenuItemClickListener false
            }
            true
        }
    }
}