package ru.mos.app.presentation.view.impl.activity.screen

import android.os.SystemClock
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.kaspersky.kaspresso.testcases.core.testcontext.BaseTestContext
import ru.mos.app.R
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.BaseTest.*
import ru.mos.app.presentation.view.impl.activity.testData.UserData

class  ServiceScreen : Screen<ServiceScreen>() {

    val backButton = KButton {withContentDescription("Navigate up")}
    val addButton = KButton {withId(R.id.fab)}

    val createdElement = KTextView {withId(R.id.title)}
    val deleteButton = KButton {withText(R.string.delete)}
    val agreeDeleteButton = KButton {withId(android.R.id.button1)}
    val changeButton = KButton {withText(R.string.profile_service_edit)}
    val alertOkButton = KButton {withText(R.string.dialog_ok)}
    val elementNotExistText = KTextView { withText(R.string.profile_service_empty_description) }

}