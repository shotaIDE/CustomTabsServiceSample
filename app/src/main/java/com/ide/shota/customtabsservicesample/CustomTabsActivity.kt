package com.ide.shota.customtabsservicesample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.webkit.WebView

class CustomTabsActivity : AppCompatActivity(), CustomTabsContract.View {

    override lateinit var presenter: CustomTabsContract.Presenter
    private lateinit var webView: WebView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_tabs_activity)

        val presenter = CustomTabsPresenter(
                Injection.provideBlackListRepository(applicationContext),
                this
        )

        webView = findViewById(R.id.main_web_view)
        webView.webViewClient = MyWebViewClient(presenter)

        toolbar = findViewById(R.id.tool_bar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onResume() {
        super.onResume()

        presenter.start()
    }

    override fun setUrl(url: String) {
        toolbar.title = url
    }

    override fun handleIntent() {
        val uri = intent.data!!
        loadUrl(uri.toString())
    }

    private fun loadUrl(url: String) {
        if (!presenter.isViewableRequestedUrl(url)) {
            return
        }

        webView.loadUrl(url)
    }
}
