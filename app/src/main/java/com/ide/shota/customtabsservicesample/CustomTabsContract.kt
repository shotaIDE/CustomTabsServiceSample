package com.ide.shota.customtabsservicesample

interface CustomTabsContract {

    interface View : BaseView<Presenter> {

        fun handleIntent()

        fun setUrl(url: String)
    }

    interface Presenter : BasePresenter {

        fun isViewableRequestedUrl(url: String) : Boolean

        fun doUpdateVisitedHistory(url: String)
    }
}
