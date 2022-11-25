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
import com.evilcorp.orangenews.databinding.FragmentItNewsBinding
import com.evilcorp.orangenews.databinding.FragmentSportsNewsBinding
import com.evilcorp.orangenews.ui.adapters.PoliticNewsAdapter

class SportsNewsFragment : Fragment() {

    private lateinit var binding: FragmentSportsNewsBinding
    private lateinit var viewModel: AllNewsViewModel
    private lateinit var prefs: SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = DataBindingUtil.inflate<ViewDataBinding>(inflater, R.layout.fragment_sports_news, container, false)
        binding = DataBindingUtil.bind(v.root)!!
        viewModel = AllNewsViewModel()
        prefs = requireActivity().getSharedPreferences("NEWS_MAIN", Context.MODE_PRIVATE)
        return v.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sportRv = binding.sportsNewsRv
        val adapter = PoliticNewsAdapter(view.context)
        sportRv.adapter = adapter
        sportRv.layoutManager = LinearLayoutManager(requireContext())
        sportRv.setHasFixedSize(true)

        val newsList: List<News> = NewsDecoder.formatNews(prefs, "sports")
        adapter.setList(newsList)
        adapter.notifyDataSetChanged()
    }

}