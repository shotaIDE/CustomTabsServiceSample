package com.ide.shota.customtabsservicesample

import android.content.Intent
import android.net.Uri
import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class) @LargeTest class CustomTabsScreenTest {

    @Rule @JvmField var customTabsActivityTestRule = ActivityTestRule(
            CustomTabsActivity::class.java,
            true,
            false)

    @Test fun orientationChange_FilterCompletedPersists() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(URL_GOOGLE))
        customTabsActivityTestRule.launchActivity(intent)

        Espresso.onView(ViewMatchers.withText(URL_GOOGLE)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        TestUtils.rotateOrientation(customTabsActivityTestRule.activity)

        Espresso.onView(ViewMatchers.withText(URL_GOOGLE)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    companion object {
        const val URL_GOOGLE = "https://www.google.co.jp/"
    }
}
