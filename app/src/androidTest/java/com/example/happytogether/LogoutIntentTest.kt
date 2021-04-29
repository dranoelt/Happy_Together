package com.example.happytogether

import android.content.Intent
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.happytogether.login.StartupActivity
import com.example.happytogether.ui.ProfileFragment
import org.hamcrest.core.AllOf
import org.junit.After
import org.junit.Before
import org.junit.Test

class LogoutIntentTest {
    @Before
    fun setUp() {
        Intents.init()
    }
    @Test
    fun clickLogoutButton() {
        val scenario = launchFragmentInContainer<ProfileFragment>()
        val expectedIntent : org.hamcrest.Matcher<Intent>? =
            AllOf.allOf(
                IntentMatchers.hasComponent(StartupActivity::class.java!!.getName())
            )
        onView(withId(R.id.btn_05_logout)).perform(click())
        Intents.intended(expectedIntent)
    }
    @After
    fun tearDown() {
        Intents.release()
    }
}