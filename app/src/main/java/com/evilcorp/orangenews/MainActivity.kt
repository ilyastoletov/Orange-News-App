package com.evilcorp.orangenews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.evilcorp.orangenews.databinding.ActivityMainBinding
import com.evilcorp.orangenews.ui.adapters.PagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this@MainActivity, R.layout.activity_main).apply { lifecycleOwner = this@MainActivity }
        initialize()
    }

    private fun initialize() {
        binding.viewPager.adapter = PagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager){
            tab, pos ->
            when(pos) {
                0 -> tab.text = "Политика"
                1 -> tab.text = "Спорт"
                2 -> tab.text = "It"
            }
        }.attach()
    }
}