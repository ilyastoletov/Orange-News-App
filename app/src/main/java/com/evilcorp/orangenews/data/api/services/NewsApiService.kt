package com.evilcorp.orangenews.data.api.services

import com.evilcorp.orangenews.data.api.models.RssModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface NewsApiService {

    @GET("feed/rss")
    fun getNews(): Call<RssModel>

}