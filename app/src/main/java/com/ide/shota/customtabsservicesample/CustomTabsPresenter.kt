package com.ide.shota.customtabsservicesample

class CustomTabsPresenter(
        private val blackListRepository: BlackListRepository,
        private val customTabsView: CustomTabsContract.View
) : CustomTabsContract.Presenter {

    init {
        customTabsView.presenter = this
    }

    override fun start() {
        customTabsView.handleIntent()
    }

    override fun isViewableRequestedUrl(url: String): Boolean {
        return blackListRepository.getRate(url).isViewable
    }

    override fun doUpdateVisitedHistory(url: String) {
        customTabsView.setUrl(url)
    }
}
