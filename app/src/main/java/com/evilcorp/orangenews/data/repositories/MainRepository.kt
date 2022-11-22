package com.evilcorp.orangenews.data.repositories

import com.evilcorp.orangenews.data.api.models.politics.RssModel
import com.evilcorp.orangenews.data.api.services.NewsRetrofitObject
import retrofit2.Call

class MainRepository {

    fun getNews(): Call<RssModel> {
        return NewsRetrofitObject.newsApi.getNews()
    }

}