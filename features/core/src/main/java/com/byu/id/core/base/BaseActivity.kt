package com.byu.id.core.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.byu.id.core.util.LocaleUtil
import com.google.android.play.core.appupdate.AppUpdateInfo
import com.google.android.play.core.install.InstallStateUpdatedListener
import com.google.android.play.core.install.model.InstallStatus
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
abstract class BaseActivity(val layout: Int) : AppCompatActivity(layout) {

//    @Inject
//    lateinit var appUpdateManager: AppUpdateManager

    private val TAG = this::class.java.name

    private val IN_APP_UPDATE = 2
    private var updateListener: InstallStateUpdatedListener?=null
// --------------------------------------------------
// --------------------------------------------------
// PROPERTIES
// --------------------------------------------------

    // --------------------------------------
    // status bar
    // --------------------------------------
//    open val statusBarMode: StatusBarMode? = null

    // --------------------------------------
    // Locale setting
    // --------------------------------------
    private var locale: Locale? = null

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)

        locale = Locale(LocaleUtil.getLanguageSelection(this))
        applyOverrideConfiguration(Configuration())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        window.statusBarColor = Color.TRANSPARENT
    }

    override fun onResume() {
        super.onResume()
//        statusBarMode?.setStatusBar(window)

        updateListener = InstallStateUpdatedListener { state ->
            if (state.installStatus() == InstallStatus.DOWNLOADED) {
                popupSnackBarForCompleteUpdate()
            }
        }
//        appUpdateManager.registerListener(updateListener)
    }

    override fun onPause() {
        super.onPause()
//        appUpdateManager.unregisterListener(updateListener)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d(
            "CONFIGURATION_CHANGED",
            "System default language:  ${LocaleUtil.getLocaleCompat(newConfig).language}"
        )
        LocaleUtil.onConfigurationChanged(this)
    }

    // to properly override configuration, such as custom font and locale
    // based on ref: https://developer.android.com/jetpack/androidx/releases/appcompat#version_120_3
    override fun applyOverrideConfiguration(overrideConfiguration: Configuration?) {
        super.applyOverrideConfiguration(
            LocaleUtil.updateConfigurationIfSupported(
                overrideConfiguration,
                locale
            )
        )
    }

    fun executeInAppUpdate(appUpdateInfo: AppUpdateInfo, isForce: Boolean = false) {
        if (isForce) {
//            appUpdateManager.startUpdateFlowForResult(
//                appUpdateInfo,
//                AppUpdateType.IMMEDIATE,
//                this,
//                IN_APP_UPDATE
//            )

        } else {
//            appUpdateManager.startUpdateFlowForResult(
//                appUpdateInfo,
//                AppUpdateType.FLEXIBLE,
//                this,
//                IN_APP_UPDATE
//            )
        }
    }

    private fun popupSnackBarForCompleteUpdate() {
//        Snackbar.make(findViewById(android.R.id.content), resources.getString(R.string.update_snackbar_title), Snackbar.LENGTH_INDEFINITE).apply {
//            setAction(resources.getString(R.string.update_snackbar_cta)) {
//                appUpdateManager.completeUpdate()
//            }
//            show()
//        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            IN_APP_UPDATE -> {
                if (resultCode != Activity.RESULT_OK) {
                    Log.e("InAppUpdateFail=>", "Update flow failed! Result code: $resultCode")
                    // If the update is cancelled or fails,
                    // you can request to start the update again.
                }
            }
        }
    }

    override fun onUserLeaveHint() {
        Log.e(TAG, "UserLeaveHint")
        super.onUserLeaveHint()
    }
}