package com.evilcorp.orangenews.data.api.services


import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.create

object NewsRetrofitObject {

    @Suppress("DEPRECATION")
    val newsApi = Retrofit.Builder()
        .baseUrl("https://vz.ru/")
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .build()
        .create(NewsApiService::class.java)

}