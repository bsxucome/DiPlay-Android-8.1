package com.shilapi.xcertplay

import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.os.Messenger
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [27])
@LooperMode(LooperMode.Mode.PAUSED)
class AndroidEightServiceCompatibilityTest {
    @Test fun connectionServiceStartsWithAnAndroidEightForegroundNotification() {
        val controller = Robolectric.buildService(DiPlaySessionService::class.java).create()
        val service = controller.get()
        try {
            assertEquals(Service.START_NOT_STICKY, service.onStartCommand(Intent(), 0, 1))
            val notification = shadowOf(service).lastForegroundNotification
            assertNotNull(notification)
            assertEquals("diplay_connection", notification.channelId)
            assertNotNull(service.getSystemService(NotificationManager::class.java)
                .getNotificationChannel(notification.channelId))
            assertNotNull(notification.contentIntent)
            assertEquals(1, notification.actions.size)
        } finally {
            controller.destroy()
        }
    }

    @Test fun launcherEmbeddingReturnsUnsupportedWithoutLoadingAndroidElevenSurfaceApis() {
        val controller = Robolectric.buildService(MapEmbedService::class.java).create()
        val service = controller.get()
        try {
            AirPlayPersistence.saveLauncherMapSharing(service, true)
            val replies = mutableListOf<Message>()
            val client = Messenger(Handler(Looper.getMainLooper()) { replies += Message.obtain(it); true })
            val endpoint = Messenger(service.onBind(Intent(MapEmbedService.ACTION)))
            endpoint.send(Message.obtain(null, MapEmbedService.MSG_ATTACH).apply { replyTo = client })
            shadowOf(Looper.getMainLooper()).idle()

            assertEquals(1, replies.size)
            assertEquals(MapEmbedService.MSG_ERROR, replies.single().what)
            assertEquals(MapEmbedService.ERROR_UNSUPPORTED,
                replies.single().data.getString(MapEmbedService.KEY_ERROR))
        } finally {
            controller.destroy()
        }
    }
}
