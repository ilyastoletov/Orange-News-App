package com.evilcorp.orangenews.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.evilcorp.orangenews.ui.screens.*

class PagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> NewsFragment("politics")
            1 -> NewsFragment("sports")
            2 -> NewsFragment("it")
            3 -> NewsFragment("culture")
            4 -> NewsFragment("none")
            else -> NewsFragment("none")
        }
    }

}