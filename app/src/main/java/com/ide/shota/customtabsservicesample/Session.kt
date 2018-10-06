package com.ide.shota.customtabsservicesample

import android.content.Intent
import android.support.customtabs.CustomTabsIntent

class Session(
        intent : Intent
) {
    var isCustomTabsSession : Boolean = false
        private set

    init {
        isCustomTabsSession = intent.hasExtra(CustomTabsIntent.EXTRA_SESSION)
    }
}
