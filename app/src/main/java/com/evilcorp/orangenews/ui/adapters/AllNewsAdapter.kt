package com.evilcorp.orangenews.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.evilcorp.orangenews.data.models.News
import com.evilcorp.orangenews.databinding.AllNewsItemBinding
import com.squareup.picasso.Picasso

class AllNewsAdapter : RecyclerView.Adapter<AllNewsAdapter.AllNewsHolder>() {

    var news: ArrayList<News> = arrayListOf(
        News("О защите языка высших приматов от птичьего влияния. Предложения в порядке обсуждения законопроекта", "https://novaya.media/static/records/aab76a680bfc432f84bf13342e464ddd.jpeg"),
        News("Не по протоколу. Что такое Минские соглашения, которые позволяли избежать боевых действий в Украине, и как они были нарушены", "https://novaya.media/static/records/0d0454c37d7a415b953a3563bf9f5fe7.jpeg"),
        News("Права женщин монетизируются и что такое экономика криптовалют. Лекции, которые рекомендует Дмитрий Прокофьев. Выпуск второй", "https://novaya.media/static/records/dfe6bfd8eb914de6a89a6d55f915cc21.jpeg"),
        News("Донорство госорганов. Сколько денег тратит Петербург на восстановление присоединенных к России областей Украины — и почему это тайна за семью печатями", "https://novaya.media/static/records/506356419d9c4a799553bb29ec6c0d01.jpeg")
    )

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
        if (news[position].title.length > 100) {
            holder.titleText.textSize = 16.0f
        }
    }

    override fun getItemCount() = news.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<News>) {
        news = list
    }
}