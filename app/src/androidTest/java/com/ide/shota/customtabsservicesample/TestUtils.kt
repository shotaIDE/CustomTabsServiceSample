package com.ide.shota.customtabsservicesample

import android.app.Activity
import android.content.pm.ActivityInfo
import android.content.res.Configuration

object TestUtils {

    private fun rotateToLandscape(activity: Activity) {
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    private fun rotateToPortrait(activity: Activity) {
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    fun rotateOrientation(activity: Activity) {
        val currentOrientation = activity.resources.configuration.orientation

        when (currentOrientation) {
            Configuration.ORIENTATION_LANDSCAPE -> rotateToPortrait(activity)
            Configuration.ORIENTATION_PORTRAIT -> rotateToLandscape(activity)
            else -> rotateToLandscape(activity)
        }
    }
}
