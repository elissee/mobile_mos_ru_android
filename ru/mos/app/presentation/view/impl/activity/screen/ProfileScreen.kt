package ru.mos.app.presentation.view.impl.activity.screen

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import ru.mos.app.R
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.BaseTest.Static.childAtPosition

class  ProfileScreen : Screen<ProfileScreen>() {
    val feedback = KTextView {withText("Обратная связь")}
    val ourApps = KTextView {withText(R.string.our_apps)}
    val aboutApp = KTextView {withText(R.string.about_app)}
    val policyOms = KTextView {withText(R.string.profile_health_care)}
    val security = KTextView {withText(R.string.security_dialog_title)}
    val transport = KTextView {withText(R.string.profile_transport)}
    val addresses = KTextView {withText(R.string.profile_my_home)}
    val childrenSchool = KTextView {withText("Дети в школе")}
    val notifications = KTextView {withText(R.string.notifications)}
    val logOut = KTextView {withText(R.string.log_out)}
    val modalLogoutButton = KButton {withId(android.R.id.button1)}
    val profileEditButton = KButton {withId(R.id.action_edit)}

    fun clickOnName(name : String) {
        onView(withText(name))
                .check(matches(isDisplayed()))
                .perform(click())
    }

}