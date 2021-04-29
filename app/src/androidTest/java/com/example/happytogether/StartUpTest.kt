package com.example.happytogether

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.happytogether.login.StartupActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class StartUpTest {
    @Rule @JvmField
    var activityTestRule = ActivityTestRule(StartupActivity::class.java)

    @Test
    fun clickLoginButton() {
        onView(withId(R.id.btn_login)).perform(click())
        onView(withId(R.id.fragment_login)).check(matches(isDisplayed()))
    }

    @Test
    fun clickRegisterButton() {
        onView(withId(R.id.btn_register)).perform(click())
        onView(withId(R.id.fragment_register)).check(matches(isDisplayed()))
    }
}