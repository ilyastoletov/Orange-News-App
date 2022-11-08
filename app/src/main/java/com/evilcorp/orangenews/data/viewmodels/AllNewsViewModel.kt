package com.evilcorp.orangenews.data.viewmodels


import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evilcorp.orangenews.data.api.models.RssModel
import com.evilcorp.orangenews.data.repositories.MainRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllNewsViewModel : ViewModel() {

    val repo = MainRepository()

    var _news: MutableLiveData<RssModel> = MutableLiveData()

    var news: LiveData<RssModel> = _news

    fun getNewsFromApi() {
        val call: Call<RssModel> = repo.getNews()
        this.executeCall(call)
    }

    private fun executeCall(call: Call<RssModel>) {
        call.enqueue(object : Callback<RssModel> {
            override fun onResponse(call: Call<RssModel>, response: Response<RssModel>) {
                if (response.isSuccessful) {
                    val rssFeed: RssModel = response.body()!!
                    _news.value = rssFeed
                } else {
                    println(response.errorBody())
                }
            }

            override fun onFailure(call: Call<RssModel>, t: Throwable) {
                println(t.message)
            }

        })
    }


}