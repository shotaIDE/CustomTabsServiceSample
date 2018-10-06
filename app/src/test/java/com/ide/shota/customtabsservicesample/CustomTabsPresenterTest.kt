package com.ide.shota.customtabsservicesample

import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class CustomTabsPresenterTest {

    @Mock private lateinit var blackListRepository: BlackListRepository

    @Mock private lateinit var customTabsView: CustomTabsContract.View

    private lateinit var customTabsPresenter: CustomTabsPresenter

    @Before fun setupCustomTabsPresenter() {
        MockitoAnnotations.initMocks(this)

        customTabsPresenter = CustomTabsPresenter(blackListRepository, customTabsView)
    }

    @Test fun createPresenter_setsThePresenterToView() {
        verify(customTabsView).presenter = customTabsPresenter
    }

    @Test fun startPresenter_callHandleIntentOfView() {
        customTabsPresenter.start()

        verify(customTabsView).handleIntent()
    }

    @Test fun isViewableRequestedUrl_returnTrue_forRate0() {
        val rate = Rate(0)
        `when`(blackListRepository.getRate(URL_GOOGLE)).thenReturn(rate)

        val isViewable = customTabsPresenter.isViewableRequestedUrl(URL_GOOGLE)

        verify(blackListRepository).getRate(URL_GOOGLE)
        assert(isViewable)
    }

    @Test fun isViewableRequestedUrl_returnFalse_forRate1() {
        val rate = Rate(1)
        `when`(blackListRepository.getRate(URL_YAHOO)).thenReturn(rate)

        val isViewable = customTabsPresenter.isViewableRequestedUrl(URL_YAHOO)

        verify(blackListRepository).getRate(URL_YAHOO)
        assert(!isViewable)
    }

    @Test fun doUpdateVisitedHistory_setUrlToView() {
        customTabsPresenter.doUpdateVisitedHistory(URL_GOOGLE)

        verify(customTabsView).setUrl(URL_GOOGLE)
    }

    companion object {
        const val URL_GOOGLE = "https://www.google.co.jp/"
        const val URL_YAHOO = "https://www.yahoo.co.jp/"
    }
}
