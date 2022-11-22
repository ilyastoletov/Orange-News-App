package com.evilcorp.orangenews.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.evilcorp.orangenews.ui.screens.PoliticNewsFragment
import com.evilcorp.orangenews.ui.screens.ItNewsFragment
import com.evilcorp.orangenews.ui.screens.SportsNewsFragment

class PagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> PoliticNewsFragment()
            1 -> SportsNewsFragment()
            2 -> ItNewsFragment()
            else -> PoliticNewsFragment()
        }
    }

}