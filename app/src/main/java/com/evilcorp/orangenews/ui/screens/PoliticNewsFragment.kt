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
import com.evilcorp.orangenews.databinding.FragmentAllNewsBinding
import com.evilcorp.orangenews.ui.adapters.PoliticNewsAdapter

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

        rvNews.apply {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }

        setupSwipeLayout(rvAdapter)

        val newsList: List<News> = NewsDecoder.formatNews(prefs, "politics")
        rvAdapter.setList(newsList)
        rvAdapter.notifyDataSetChanged()
    }

    private fun setupSwipeLayout(rvAdapter: PoliticNewsAdapter) {

        binding.politicsSwipeLayout.setOnRefreshListener {
            viewModel.getNewsFromApi()
            viewModel.news.observe(viewLifecycleOwner) {
                NewsDecoder.saveNews(it, prefs)
                val news: List<News> = NewsDecoder.formatNews(prefs, "politics")
                rvAdapter.setList(news)
                rvAdapter.notifyDataSetChanged()
                binding.politicsSwipeLayout.isRefreshing = false
            }
        }

    }

}