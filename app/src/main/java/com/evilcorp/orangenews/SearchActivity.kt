package com.evilcorp.orangenews

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.evilcorp.orangenews.data.models.News
import com.evilcorp.orangenews.data.utils.NewsDecoder
import com.evilcorp.orangenews.databinding.ActivitySearchBinding
import com.evilcorp.orangenews.ui.adapters.PoliticNewsAdapter

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivitySearchBinding?>(this@SearchActivity, R.layout.activity_search).apply { lifecycleOwner = this@SearchActivity }
        prefs = getSharedPreferences("NEWS_MAIN", Context.MODE_PRIVATE)

        supportActionBar!!.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Поиск"
        }
    }

    private fun searchEngine(query: String) {

        /* Setting up recycler view */
        val rvAdapter = PoliticNewsAdapter(applicationContext)
        val rv = binding.searchQueryResults
        rv.apply {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(context)
        }

        val newsList = NewsDecoder.formatNews(prefs)
        val searchedNews: MutableList<News> = mutableListOf()

        for (article in newsList) {
            if (article.title.contains(query, ignoreCase = true)) {
                searchedNews.add(article)
            }
        }

        if (searchedNews.size == 0) {
            Toast.makeText(applicationContext, "По вашему запросу ничего не найдено", Toast.LENGTH_SHORT).show()
        } else {
            rvAdapter.setList(searchedNews)
            rvAdapter.notifyDataSetChanged()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.search_menu, menu)
        val menuItem: MenuItem = menu!!.findItem(R.id.action_search)
        val searchView: SearchView = menuItem.actionView as SearchView
        searchView.queryHint = "Введите заголовок новости"

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchEngine(query!!)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })


        return super.onCreateOptionsMenu(menu)
    }

}