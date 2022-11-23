package com.evilcorp.orangenews


import android.content.Intent
import android.net.Uri
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

        binding.btnLinkToArticle.setOnClickListener {
            val uri = Uri.parse(intent.getStringExtra("ArticleLink"))
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

    private fun loadHtml(htmlString: String) {
        val plainTextFromHtml = HtmlCompat.fromHtml(htmlString, HtmlCompat.FROM_HTML_MODE_LEGACY)
        binding.articleText.text = plainTextFromHtml
    }


}