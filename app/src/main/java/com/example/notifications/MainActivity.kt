package com.example.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {

    lateinit var notificationManager: NotificationManager
    lateinit var notification: Notification

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(
            NotificationChannel(
                packageName,
                "channelName",
                NotificationManager.IMPORTANCE_DEFAULT
            )
        )

        notification = NotificationCompat.Builder(this, packageName)
            .setContentText("Notification Text")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()
    }

    fun showNotification(view: View) {
        notificationManager.notify(0, notification)
    }
}