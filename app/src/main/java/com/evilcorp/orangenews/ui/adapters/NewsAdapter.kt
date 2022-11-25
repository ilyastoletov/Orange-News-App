package com.evilcorp.orangenews.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.evilcorp.orangenews.ArticleActivity
import com.evilcorp.orangenews.data.models.News
import com.evilcorp.orangenews.databinding.AllNewsItemBinding
import com.squareup.picasso.Picasso

class NewsAdapter(private val context: Context) : RecyclerView.Adapter<NewsAdapter.AllNewsHolder>() {

    var news: List<News> = arrayListOf()

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
        holder.titleText.textSize = getFontSize(news[position].title.length)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ArticleActivity::class.java)
            intent.putExtra("ArticleTitle", news[position].title)
            intent.putExtra("ArticleText", news[position].articleText)
            intent.putExtra("ArticleImage", news[position].imageUrl)
            intent.putExtra("ArticleLink", news[position].articleLink)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }

    }

    private fun getFontSize(length: Int): Float {
        return when (length) {
            in 0..50 -> 22.0f
            in 50..100 -> 18.0f
            in 100..150 -> 15.0f
            in 150..200 -> 13.0f
            else -> 11.0f
        }
    }

    override fun getItemCount() = news.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<News>) {
        news = list
    }
}