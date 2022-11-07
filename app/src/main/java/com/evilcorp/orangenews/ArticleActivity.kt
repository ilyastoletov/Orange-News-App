package com.evilcorp.orangenews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import com.evilcorp.orangenews.databinding.ActivityArticleBinding
import com.squareup.picasso.Picasso

class ArticleActivity : AppCompatActivity() {

    lateinit var binding: ActivityArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@ArticleActivity, R.layout.activity_article)
        binding.lifecycleOwner = this
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = ""
        binding.articleTitle.text = intent.getStringExtra("ArticleTitle")
        binding.articleText.text = HtmlCompat.fromHtml(intent.getStringExtra("ArticleText")!!, HtmlCompat.FROM_HTML_MODE_LEGACY)
        Picasso.get().load(intent.getStringExtra("ArticleImage")).into(binding.articleImage)
    }


}