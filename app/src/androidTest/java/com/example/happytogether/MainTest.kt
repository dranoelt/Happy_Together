package com.example.happytogether

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainTest {
    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun navigationClick() {
        onView(withId(R.id.nav_cart)).perform(click())
        onView(withId(R.id.fragment_cart)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.nav_messages)).perform(click())
        onView(withId(R.id.fragment_message)).check(matches(isDisplayed()))
        onView(withId(R.id.nav_profile)).perform(click())
        onView(withId(R.id.fragment_profile)).check(matches(isDisplayed()))
        onView(withId(R.id.nav_home)).perform(click())
        onView(withId(R.id.fragment_home)).check(matches(isDisplayed()))
    }
}