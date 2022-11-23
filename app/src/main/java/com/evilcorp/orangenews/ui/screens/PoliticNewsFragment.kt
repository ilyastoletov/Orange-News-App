package com.evilcorp.orangenews.ui.screens

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.evilcorp.orangenews.R
import com.evilcorp.orangenews.data.api.models.politics.RssModel
import com.evilcorp.orangenews.data.models.News
import com.evilcorp.orangenews.data.viewmodels.AllNewsViewModel
import com.evilcorp.orangenews.databinding.FragmentAllNewsBinding
import com.evilcorp.orangenews.ui.adapters.PoliticNewsAdapter
import com.google.gson.Gson

class PoliticNewsFragment : Fragment() {

    lateinit var binding: FragmentAllNewsBinding
    lateinit var viewModel: AllNewsViewModel
    lateinit var prefs: SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = DataBindingUtil.inflate<ViewDataBinding>(inflater, R.layout.fragment_all_news, container, false)
        binding = DataBindingUtil.bind(v.root)!!
        viewModel = AllNewsViewModel()
        prefs = requireActivity().getSharedPreferences("NEWS_MAIN", Context.MODE_PRIVATE)
        return v.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvNews = binding.rvNews
        val rvAdapter = PoliticNewsAdapter(view.context)
        rvNews.adapter = rvAdapter
        rvNews.layoutManager = LinearLayoutManager(requireContext())
        rvNews.setHasFixedSize(true)
        val newsList: List<News> = formatNews()
        rvAdapter.setList(newsList)
        rvAdapter.notifyDataSetChanged()
    }

    private fun formatNews(): List<News> {
        val newsFromPrefs = prefs.getString("politic_news", "")
        val gsonDecoder = Gson()
        val formattedNews = gsonDecoder.fromJson(newsFromPrefs, RssModel::class.java)
        val newsList = formattedNews.articles
        val readyNews: MutableList<News> = mutableListOf()

        for (article in newsList) {
            readyNews.add(News(
                title=article.articleTitle,
                imageUrl=article.image.imageUrl,
                articleText=article.articleText,
                articleCategory=article.articleCategory,
                articleLink=article.articleLink
            ))
        }
        return readyNews
    }

}