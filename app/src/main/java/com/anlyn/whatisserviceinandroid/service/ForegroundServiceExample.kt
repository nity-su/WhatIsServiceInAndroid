package com.anlyn.whatisserviceinandroid.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.content.res.TypedArrayUtils.getText
import com.anlyn.whatisserviceinandroid.MainActivity
import com.anlyn.whatisserviceinandroid.R

class ForegroundServiceExample(val context: Context) {
    val pendingIntent: PendingIntent =
            Intent(context, MainActivity::class.java).let { notificationIntent ->
                PendingIntent.getActivity(context, 0, notificationIntent, 0)
            }

    val notification: Notification = NotificationCompat.Builder(context, "channel 2")
            .setContentTitle(context.getText(R.string.notification_title))
            .setContentText(context.getText(R.string.notification_message))
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentIntent(pendingIntent)
            .setTicker("")
            .build()

// Notification ID cannot be 0.
}