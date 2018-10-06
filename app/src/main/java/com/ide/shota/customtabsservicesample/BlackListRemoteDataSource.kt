package com.ide.shota.customtabsservicesample

class BlackListRemoteDataSource private constructor() : BlackListDataSource {

    override fun getRate(url: String): Rate {
        // FIXME: サーバと通信して取得
        return Rate( 0)
    }

    companion object {

        private lateinit var INSTANCE: BlackListRemoteDataSource
        private var needsNewInstance = true

        @JvmStatic fun getInstance(): BlackListRemoteDataSource {
            if (needsNewInstance) {
                INSTANCE = BlackListRemoteDataSource()
                needsNewInstance = false
            }
            return INSTANCE
        }
    }
}
