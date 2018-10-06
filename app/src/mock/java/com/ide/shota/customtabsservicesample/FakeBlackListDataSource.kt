package com.ide.shota.customtabsservicesample

open class FakeBlackListDataSource private constructor() : BlackListDataSource {

    override fun getRate(url: String): Rate {
        // 全て許可を返す
        return Rate(0)
    }

    companion object {

        private lateinit var INSTANCE: FakeBlackListDataSource
        private var needsNewInstance = true

        @JvmStatic fun getInstance(): FakeBlackListDataSource {
            if (needsNewInstance) {
                INSTANCE = FakeBlackListDataSource()
                needsNewInstance = false
            }
            return INSTANCE
        }
    }
}
