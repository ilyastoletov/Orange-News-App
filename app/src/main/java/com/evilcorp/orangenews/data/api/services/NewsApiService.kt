package com.evilcorp.orangenews.data.api.services

import com.evilcorp.orangenews.data.api.models.politics.RssModel
import retrofit2.Call
import retrofit2.http.GET

interface NewsApiService {

    @GET("https://vz.ru/rss.xml")
    fun getNews(): Call<RssModel>

}