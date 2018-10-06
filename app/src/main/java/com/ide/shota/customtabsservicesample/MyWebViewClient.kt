package com.ide.shota.customtabsservicesample

import android.os.Build
import android.support.annotation.RequiresApi
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class MyWebViewClient(
        private val presenter : CustomTabsContract.Presenter
) : WebViewClient() {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        if (request == null) {
            return false
        }

        val url = request.url.toString()
        return !presenter.isViewableRequestedUrl(url)
    }

    override fun doUpdateVisitedHistory(view: WebView?, url: String?, isReload: Boolean) {
        super.doUpdateVisitedHistory(view, url, isReload)

        if (url == null) {
            return
        }

        presenter.doUpdateVisitedHistory(url)
    }
}
