package com.evilcorp.orangenews.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.evilcorp.orangenews.ui.screens.AllNewsFragment
import com.evilcorp.orangenews.ui.screens.PoliticsNewsFragment
import com.evilcorp.orangenews.ui.screens.SportsNewsFragment

class PagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> AllNewsFragment()
            1 -> SportsNewsFragment()
            2 -> PoliticsNewsFragment()
            else -> AllNewsFragment()
        }
    }

}