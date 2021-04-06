package com.anlyn.whatisserviceinandroid.service

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.anlyn.whatisserviceinandroid.MainActivity
import com.anlyn.whatisserviceinandroid.R

class ForegroundServiceExample2() :Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel()
            val notification = Notification.Builder(this, "CHANNEL_ID")
                    .setContentTitle("title")
                    .setContentText("text")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setTicker("")
                    .build()

            startForeground(3, notification)
        }
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    private fun createNotificationChannel() {
        val notificationChannel = NotificationChannel(
                "CHANNEL_ID",
                "MyApp notification",
                NotificationManager.IMPORTANCE_HIGH
        )
        notificationChannel.enableLights(true)
        notificationChannel.lightColor = Color.RED
        notificationChannel.enableVibration(true)
        notificationChannel.description = "AppApp Tests"

        val notificationManager = applicationContext.getSystemService(
                Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(
                notificationChannel)
    }
}