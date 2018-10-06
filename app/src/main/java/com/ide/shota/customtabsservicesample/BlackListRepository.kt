package com.ide.shota.customtabsservicesample

open class BlackListRepository(
        private val blackListRemoteDataSource: BlackListDataSource
) : BlackListDataSource {

    private var cachedRates: HashMap<String, Rate> = HashMap()

    override fun getRate(url: String): Rate {
        val cachedRate = cachedRates[url]
        if (cachedRate != null) {
            return cachedRate
        }

        val rate = blackListRemoteDataSource.getRate(url)
        cachedRates[url] = rate
        return rate
    }
}
