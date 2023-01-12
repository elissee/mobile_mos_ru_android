package ru.mos.app.presentation.view.impl.activity.screen

import android.os.SystemClock
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.longClick
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import ru.mos.app.R
import ru.mos.app.presentation.view.impl.activity.BaseTest.Static.LONG_DELAY
import ru.mos.app.presentation.view.impl.activity.BaseTest.Static.SHORT_DELAY
import ru.mos.app.presentation.view.impl.activity.BaseTest.Static.waitViewShown

class NotificationsScreen : Screen<NotificationsScreen>() {

    val backButton = KButton {withContentDescription("Navigate up")}

    fun checkNotification(notificationName: String) {
        onView(withText(notificationName))
                .perform(longClick())
        onView(withId(R.id.pushGroup))
                .check(matches(isDisplayed()))
        SystemClock.sleep(SHORT_DELAY)
        onView(withContentDescription("Navigate up"))
                .check(matches(isDisplayed()))
                .perform(click())
    }
}