package ai.ftech.mylauncher

import android.app.Application

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppPreferences.init(this)
    }
}