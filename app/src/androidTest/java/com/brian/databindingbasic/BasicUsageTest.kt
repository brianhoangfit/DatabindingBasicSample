package com.brian.databindingbasic


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class BasicUsageTest {

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun viewModelActivity_likes() {

        // Click Like 10 times
        repeat(10) {
            onView(ViewMatchers.withId(R.id.like_button)).perform(ViewActions.click())
        }

        // Check the number of likes is displayed
        onView(ViewMatchers.withId(R.id.likes_value)).check(ViewAssertions.matches(ViewMatchers.withText("10")))

    }
}
