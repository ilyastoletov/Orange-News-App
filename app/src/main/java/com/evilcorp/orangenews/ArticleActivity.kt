package com.evilcorp.orangenews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.evilcorp.orangenews.databinding.ActivityArticleBinding

class ArticleActivity : AppCompatActivity() {

    lateinit var binding: ActivityArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@ArticleActivity, R.layout.activity_article)
        val articleTitle = intent.getStringExtra("ArticleTitle")
        val articleText = intent.getStringExtra("ArticleText")
        binding.lifecycleOwner = this
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = ""
    }


}