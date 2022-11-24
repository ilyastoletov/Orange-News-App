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
            0 -> PoliticNewsFragment()
            1 -> SportsNewsFragment()
            2 -> ItNewsFragment()
            3 -> CultureNewsFragment()
            4 -> AllNewsFragment()
            else -> PoliticNewsFragment()
        }
    }

}