package com.orgzly.android.sync


import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.orgzly.BuildConfig
import com.orgzly.android.*
import com.orgzly.android.util.LogUtils


class SyncService : Service() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.LOG_DEBUG) LogUtils.d(TAG)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (BuildConfig.LOG_DEBUG) LogUtils.d(TAG, intent)

        if (intent != null && AppIntent.ACTION_SYNC_START == intent.action) {
            SyncRunner.startSync()
        }

        return Service.START_REDELIVER_INTENT
    }

    override fun onBind(intent: Intent): IBinder? {
        if (BuildConfig.LOG_DEBUG) LogUtils.d(TAG)
        return null
    }

    override fun onDestroy() {
        super.onDestroy()

        if (BuildConfig.LOG_DEBUG) LogUtils.d(TAG)
    }

    companion object {
        private val TAG = SyncService::class.java.name
    }
}
