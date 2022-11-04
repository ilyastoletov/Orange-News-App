package com.evilcorp.orangenews.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.evilcorp.orangenews.R
import com.evilcorp.orangenews.databinding.FragmentAllNewsBinding

class AllNewsFragment : Fragment() {

    lateinit var binding: FragmentAllNewsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = DataBindingUtil.inflate<ViewDataBinding>(inflater, R.layout.fragment_all_news, container, false)
        binding = DataBindingUtil.bind(v.root)!!
        return v.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}