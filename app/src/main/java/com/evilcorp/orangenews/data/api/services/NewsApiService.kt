package com.evilcorp.orangenews.data.api.services

import com.evilcorp.orangenews.data.api.models.politics.RssModel
import retrofit2.Call
import retrofit2.http.GET

interface NewsApiService {

    @GET("rss")
    fun getNews(): Call<RssModel>

}