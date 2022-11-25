package com.evilcorp.orangenews

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.evilcorp.orangenews.databinding.ActivityMainBinding
import com.evilcorp.orangenews.ui.adapters.PagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this@MainActivity, R.layout.activity_main).apply { lifecycleOwner = this@MainActivity }
        prefs = getSharedPreferences("NEWS_MAIN", Context.MODE_PRIVATE)
        initialize()
        setupSearchButton()
    }

    private fun initialize() {
        binding.viewPager.adapter = PagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager){
            tab, pos ->
            when(pos) {
                0 -> tab.text = "Политика"
                1 -> tab.text = "Спорт"
                2 -> tab.text = "It"
                3 -> tab.text = "Культура"
                4 -> tab.text = "Все"
            }
        }.attach()
    }

    private fun setupSearchButton() {
        binding.searchBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, SearchActivity::class.java)
            startActivity(intent)
        }
    }

}