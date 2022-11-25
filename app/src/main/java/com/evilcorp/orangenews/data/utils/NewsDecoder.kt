package com.evilcorp.orangenews.data.utils

import android.content.SharedPreferences
import com.evilcorp.orangenews.data.api.models.politics.RssModel
import com.evilcorp.orangenews.data.models.News
import com.google.gson.Gson

object NewsDecoder {

    /* Getting news from SharedPreferences and sorting them by categories */
    fun formatNews(prefs: SharedPreferences, category: String): List<News> {
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
                articleCategory= getArticleCategory(article.articleCategory),
                articleLink=article.articleLink
            )
            )
        }

        if (category == "none") {
            return pendingNews
        }

        val finalNewsList: MutableList<News> = mutableListOf()
        for (article in pendingNews) {
            if (article.articleCategory == category) {
                finalNewsList.add(article)
            }
        }

        return finalNewsList
    }

    private fun getArticleCategory(category: String): String {
        return when(category) {
            "Россия", "Мир", "Экономика", "Силовые структуры" -> "politics"
            "Наука и техника" -> "it"
             "Спорт" -> "sports"
            "Культура", "Путешествия" -> "culture"
            else -> "other"
        }
    }

    fun saveNews(data: Any, prefs: SharedPreferences) {
        val gson = Gson()
        val editor = prefs.edit()

        val jsonData = gson.toJson(data)
        editor.putString("politic_news", jsonData)
        editor.commit()
    }

}