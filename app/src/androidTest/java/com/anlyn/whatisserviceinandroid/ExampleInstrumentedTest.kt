package com.anlyn.whatisserviceinandroid

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Looper
import android.util.Log
import androidx.core.app.NotificationManagerCompat
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ServiceTestRule
import com.anlyn.whatisserviceinandroid.service.ForegroundServiceExample
import com.anlyn.whatisserviceinandroid.service.ServiceBindingEx
import com.anlyn.whatisserviceinandroid.service.ServiceConnection
import com.anlyn.whatisserviceinandroid.service.ServiceExample

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import java.util.concurrent.TimeUnit

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val serviceRule = ServiceTestRule.withTimeout(10,TimeUnit.SECONDS)
    @Before
    fun before(){

    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        var forgroud = ForegroundServiceExample(appContext)
        val nm = NotificationManagerCompat.from(appContext)
        nm.notify(1,ForegroundServiceExample(appContext).notification)


        assertEquals("com.anlyn.whatisserviceinandroid", appContext.packageName)
    }
}