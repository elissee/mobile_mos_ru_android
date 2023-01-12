package ru.mos.app.presentation.view.impl.activity.screen

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.tabs.KTabLayout
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.kaspersky.kaspresso.testcases.core.testcontext.BaseTestContext
import ru.mos.app.R
import ru.mos.app.presentation.view.impl.activity.BaseTest.Static.shouldBeDisplayed
import ru.mos.app.presentation.view.impl.activity.utils.NestedScrollViewExtension

class  OurAppsScreen : Screen<OurAppsScreen>() {
//    val screenTitle = KTextView { withText(R.string.our_apps)};
    val backButton = KButton {withContentDescription("Navigate up")}
    val appsList = KTabLayout {withId(R.id.container_friendly_apps)}
    val app = KTextView {withText("Активный гражданин")}

    fun BaseTestContext.checkApps() {
        shouldBeDisplayed(withText("Активный гражданин"))
        onView(withText("Наш город"))
                .check(matches(isEnabled()))
                .perform(NestedScrollViewExtension())
        onView(withText("Метро Москвы – схема метро, МЦД и МЦК"))
                .check(matches(isEnabled()))
                .perform(NestedScrollViewExtension())
        onView(withText("Парковки Москвы New"))
                .check(matches(isEnabled()))
                .perform(NestedScrollViewExtension())
        onView(withText("Узнай Москву"))
                .check(matches(isEnabled()))
                .perform(NestedScrollViewExtension())
        onView(withText("Помощник Москвы: борьба с нарушениями парковки"))
                .check(matches(isEnabled()))
                .perform(NestedScrollViewExtension())
        onView(withText("Мосгорпасс"))
                .check(matches(isEnabled()))
                .perform(NestedScrollViewExtension())
        onView(withText("HISTARS"))
                .check(matches(isEnabled()))
                .perform(NestedScrollViewExtension())
        onView(withText("Зарядье"))
                .check(matches(isEnabled()))
                .perform(NestedScrollViewExtension())
        onView(withText("Moscow AR VR"))
                .check(matches(isEnabled()))
                .perform(NestedScrollViewExtension())
        onView(withText("Иду в музей"))
                .check(matches(isEnabled()))
                .perform(NestedScrollViewExtension())
    }

}