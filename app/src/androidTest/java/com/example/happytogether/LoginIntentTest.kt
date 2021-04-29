package com.example.happytogether

import android.content.Intent
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.happytogether.login.LoginFragment
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class LoginIntentTest {
    @Before
    fun setUp() {
        Intents.init()
    }
    @Test
    fun clickLoginButton() {
//        onView(withId(R.id.password)).perform(typeText("alo"))
        val scenario = launchFragmentInContainer<LoginFragment>()
        val expectedIntent : org.hamcrest.Matcher<Intent>? =
            allOf(
                hasComponent(MainActivity::class.java!!.getName())
            )
        onView(withId(R.id.btn_login)).perform(click())
        intended(expectedIntent)
    }
    @After
    fun tearDown() {
        Intents.release()
    }
}