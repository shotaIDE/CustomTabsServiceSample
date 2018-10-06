package com.ide.shota.customtabsservicesample

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class BlackListRepositoryTest {

    @Mock private lateinit var blackListRemoteDataSource: FakeBlackListDataSource

    private lateinit var blackListRepository: BlackListRepository

    @Before fun setupBlackListRepository() {
        MockitoAnnotations.initMocks(this)

        blackListRepository = BlackListRepository(blackListRemoteDataSource)
    }

    @Test fun getRateSometimes_cachedDataUsed() {
        val dataSourceRate = Rate(0)
        `when`(blackListRemoteDataSource.getRate(URL_GOOGLE)).thenReturn(dataSourceRate)

        var returnRate = blackListRepository.getRate(URL_GOOGLE)
        assertThat(returnRate, `is`(dataSourceRate))

        returnRate = blackListRepository.getRate(URL_GOOGLE)
        assertThat(returnRate, `is`(dataSourceRate))

        verify(blackListRemoteDataSource, times(1)).getRate(URL_GOOGLE)
    }

    companion object {
        const val URL_GOOGLE = "https://www.google.co.jp/"
    }
}
