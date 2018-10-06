package com.ide.shota.customtabsservicesample

import android.app.Service
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.IBinder
import android.support.customtabs.ICustomTabsCallback
import android.support.customtabs.ICustomTabsService

class CustomTabsService : Service() {
    override fun onBind(intent: Intent): IBinder? {
        return object : ICustomTabsService.Stub() {
            override fun warmup(flags: Long): Boolean {
                return true
            }

            override fun newSession(callback: ICustomTabsCallback): Boolean {
                return true
            }

            override fun mayLaunchUrl(callback: ICustomTabsCallback, url: Uri, extras: Bundle, otherLikelyBundles: List<Bundle>): Boolean {
                return true
            }

            override fun extraCommand(s: String, bundle: Bundle): Bundle? {
                return null
            }

            override fun updateVisuals(callback: ICustomTabsCallback, bundle: Bundle): Boolean {
                return false
            }

            override fun requestPostMessageChannel(iCustomTabsCallback: ICustomTabsCallback,
                                                   uri: Uri): Boolean {
                return false
            }

            override fun postMessage(iCustomTabsCallback: ICustomTabsCallback, s: String,
                                     bundle: Bundle): Int {
                return 0
            }

            override fun validateRelationship(iCustomTabsCallback: ICustomTabsCallback, i: Int, uri: Uri, bundle: Bundle): Boolean {
                return false
            }
        }
    }
}
