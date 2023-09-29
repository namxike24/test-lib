package ai.ftech.nationflag

import android.app.Application

class MyApplication : Application() {

    companion object {
        var appInstance: MyApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }
}