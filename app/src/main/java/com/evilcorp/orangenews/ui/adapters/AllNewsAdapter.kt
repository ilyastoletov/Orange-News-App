package com.evilcorp.orangenews.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.evilcorp.orangenews.ArticleActivity
import com.evilcorp.orangenews.data.models.News
import com.evilcorp.orangenews.databinding.AllNewsItemBinding
import com.squareup.picasso.Picasso

class AllNewsAdapter(val context: Context) : RecyclerView.Adapter<AllNewsAdapter.AllNewsHolder>() {

    var news: List<News> = arrayListOf(News("Загрузка...", "https://www.clipartmax.com/png/full/328-3285005_big-image-pill.png"))

    class AllNewsHolder(itemView: View, binding: AllNewsItemBinding) : RecyclerView.ViewHolder(itemView) {
        val titleImage: ImageView = binding.titleImage
        val titleText: TextView = binding.tvTitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllNewsHolder {
        val binding: AllNewsItemBinding = AllNewsItemBinding.inflate(LayoutInflater.from(parent.context))
        return AllNewsHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: AllNewsHolder, position: Int) {
        Picasso.get().load(news[position].imageUrl).into(holder.titleImage)
        holder.titleText.text = news[position].title
        when (news[position].title.length) {
            in 0..50 -> holder.titleText.textSize = 22.0f
            in 50..100 -> holder.titleText.textSize = 18.0f
            in 100..150 -> holder.titleText.textSize = 15.0f
            in 150..200 -> holder.titleText.textSize = 13.0f
            else -> holder.titleText.textSize = 11.0f
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ArticleActivity::class.java)
            intent.putExtra("ArticleTitle", news[position].title)
            intent.putExtra("ArticleText", news[position].articleText)
        }
    }

    override fun getItemCount() = news.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<News>) {
        news = list
    }
}