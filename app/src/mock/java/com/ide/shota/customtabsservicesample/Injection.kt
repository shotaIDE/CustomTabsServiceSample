package com.ide.shota.customtabsservicesample

import android.content.Context

object Injection {

    fun provideBlackListRepository(context: Context): BlackListRepository {
        return BlackListRepository(FakeBlackListDataSource.getInstance())
    }
}
