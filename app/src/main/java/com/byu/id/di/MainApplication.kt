package com.byu.id.di

import android.app.Application
import com.byu.id.core.util.LocaleUtil
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        LocaleUtil.init(this)
    }
}