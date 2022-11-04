package com.evilcorp.orangenews.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.evilcorp.orangenews.data.models.News
import com.evilcorp.orangenews.databinding.AllNewsItemBinding

class AllNewsAdapter(var news: List<News>) : RecyclerView.Adapter<AllNewsAdapter.AllNewsHolder>() {

    class AllNewsHolder(itemView: View, binding: AllNewsItemBinding) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllNewsHolder {
        val binding: AllNewsItemBinding = AllNewsItemBinding.inflate(LayoutInflater.from(parent.context))
        return AllNewsHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: AllNewsHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = news.size
}