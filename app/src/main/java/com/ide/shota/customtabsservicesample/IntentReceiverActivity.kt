package com.ide.shota.customtabsservicesample

import android.app.Activity
import android.content.Intent
import android.os.Bundle

class IntentReceiverActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val session = Session(intent)
        if (session.isCustomTabsSession) {
            dispatchCustomTabsIntent()
        }

        finish()
    }

    private fun dispatchCustomTabsIntent() {
        val intent = Intent(intent)
        intent.setClassName(applicationContext, CustomTabsActivity::class.java.name)
        startActivity(intent)
    }
}
