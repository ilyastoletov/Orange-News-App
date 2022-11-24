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
import com.evilcorp.orangenews.data.models.News
import com.evilcorp.orangenews.data.utils.NewsDecoder
import com.evilcorp.orangenews.data.viewmodels.AllNewsViewModel
import com.evilcorp.orangenews.databinding.FragmentCultureNewsBinding
import com.evilcorp.orangenews.databinding.FragmentItNewsBinding
import com.evilcorp.orangenews.databinding.FragmentSportsNewsBinding
import com.evilcorp.orangenews.ui.adapters.PoliticNewsAdapter

class CultureNewsFragment : Fragment() {

    private lateinit var binding: FragmentCultureNewsBinding
    private lateinit var viewModel: AllNewsViewModel
    private lateinit var prefs: SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = DataBindingUtil.inflate<ViewDataBinding>(inflater, R.layout.fragment_culture_news, container, false)
        binding = DataBindingUtil.bind(v.root)!!
        viewModel = AllNewsViewModel()
        prefs = requireActivity().getSharedPreferences("NEWS_MAIN", Context.MODE_PRIVATE)
        return v.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itRv = binding.cultureNewsRv
        val adapter = PoliticNewsAdapter(view.context)
        itRv.adapter = adapter
        itRv.layoutManager = LinearLayoutManager(requireContext())
        itRv.setHasFixedSize(true)

        val newsList: List<News> = NewsDecoder.formatNews(prefs)
        println(newsList.size.toString())
        val finalNewsList: MutableList<News> = mutableListOf()
        for (article in newsList) {
            if (article.articleCategory == "culture") {
                finalNewsList.add(article)
            }
        }
        println(finalNewsList.size.toString())
        adapter.setList(finalNewsList)
        adapter.notifyDataSetChanged()
    }

}