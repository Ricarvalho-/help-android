package com.ricarvalho.help.common

import com.google.android.material.tabs.TabLayout

interface OnTabSelectedListener : TabLayout.OnTabSelectedListener {
    override fun onTabSelected(tab: TabLayout.Tab?) = Unit
    override fun onTabUnselected(tab: TabLayout.Tab?) = Unit
    override fun onTabReselected(tab: TabLayout.Tab?) = Unit
}

fun TabLayout.addOnTabSelectedListener(onTabSelected: (tab: TabLayout.Tab?) -> Unit) =
        addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) = onTabSelected.invoke(tab)
        })