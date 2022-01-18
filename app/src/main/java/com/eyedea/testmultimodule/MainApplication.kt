package com.eyedea.testmultimodule

import android.app.Application
import com.eyedea.core.util.LocaleUtil
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        LocaleUtil.init(this)
    }
}