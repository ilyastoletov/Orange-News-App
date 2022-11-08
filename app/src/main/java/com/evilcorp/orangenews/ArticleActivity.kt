package com.evilcorp.orangenews


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import com.evilcorp.orangenews.databinding.ActivityArticleBinding
import com.evilcorp.orangenews.ui.utils.ImageGetter
import com.squareup.picasso.Picasso

class ArticleActivity : AppCompatActivity() {

    lateinit var binding: ActivityArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@ArticleActivity, R.layout.activity_article)
        binding.lifecycleOwner = this
        val title = intent.getStringExtra("ArticleTitle")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = title
        binding.articleTitle.text = title
        loadHtml(intent.getStringExtra("ArticleText")!!)
        Picasso.get().load(intent.getStringExtra("ArticleImage")).into(binding.articleImage)
    }

    private fun loadHtml(htmlString: String) {
        val imageGetter = ImageGetter(resources, binding.articleText)
        val plainTextFromHtml = HtmlCompat.fromHtml(htmlString, HtmlCompat.FROM_HTML_MODE_LEGACY, imageGetter, null)
        binding.articleText.text = plainTextFromHtml
    }


}