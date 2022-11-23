package com.evilcorp.orangenews

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.evilcorp.orangenews.data.api.models.politics.RssModel
import com.evilcorp.orangenews.data.viewmodels.AllNewsViewModel
import com.google.gson.Gson

class SplashScreen : AppCompatActivity() {

    lateinit var prefs: SharedPreferences
    lateinit var vm: AllNewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefs = getSharedPreferences("NEWS_MAIN", Context.MODE_PRIVATE)
        vm = AllNewsViewModel()
        vm.getNewsFromApi()

        vm.news.observe(this@SplashScreen) {
            saveDataToPrefs(it)
            val intent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun saveDataToPrefs(data: RssModel) {
        val gson = Gson()
        val editor = prefs.edit()

        val jsonData = gson.toJson(data)
        editor.putString("politic_news", jsonData)
        editor.commit()
    }
}