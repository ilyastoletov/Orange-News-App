package com.evilcorp.orangenews.data.utils

import android.content.SharedPreferences
import com.evilcorp.orangenews.data.api.models.politics.RssModel
import com.evilcorp.orangenews.data.models.News
import com.google.gson.Gson

object NewsDecoder {
    fun formatNews(prefs: SharedPreferences): List<News> {
        val newsFromPrefs = prefs.getString("politic_news", "")
        val gsonDecoder = Gson()
        val formattedNews = gsonDecoder.fromJson(newsFromPrefs, RssModel::class.java)
        val newsList = formattedNews.articles
        val pendingNews: MutableList<News> = mutableListOf()

        for (article in newsList) {
            pendingNews.add(
                News(
                title=article.articleTitle,
                imageUrl=article.image.imageUrl,
                articleText=article.articleText,
                articleCategory=when(article.articleCategory) {
                    "Россия", "Мир", "Экономика", "Силовые структуры", "Ценности", "Бывший СССР" -> "politics"
                    "Наука и техника", "Интернет и СМИ" -> "it"
                    "Путешествия", "Из Жизни", "Среда обитания", "Забота о себе" -> "sports"
                    else -> "politics"
                },
                articleLink=article.articleLink
            )
            )
        }
        return pendingNews
    }
}