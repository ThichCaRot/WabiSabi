package com.thichcarot.wabisabi

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Matcher


class MainActivity : AppCompatActivity() {
    private var mywebView: WebView? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        val intent = intent
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mywebView = findViewById<View>(R.id.webview) as WebView
        mywebView!!.webViewClient = WebViewClient()
        mywebView!!.webChromeClient = WebChromeClient()
        mywebView!!.settings.javaScriptEnabled = true
        mywebView!!.settings.domStorageEnabled = true
        mywebView!!.loadUrl("https://nextjs-swart-beta-51.vercel.app/")
        val webSettings = mywebView!!.settings
        webSettings.javaScriptEnabled = true
        webSettings.allowUniversalAccessFromFileURLs = true

    }

    inner class mywebClient : WebViewClient() {
        override fun onPageStarted(view: WebView, url: String, favicon: Bitmap) {
            super.onPageStarted(view, url, favicon)
        }

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }

    override fun onBackPressed() {
        if (mywebView!!.canGoBack()) {
            mywebView!!.goBack()
        } else {
            super.onBackPressed()
        }
    }


}