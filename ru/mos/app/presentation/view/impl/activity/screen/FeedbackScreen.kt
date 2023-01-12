package ru.mos.app.presentation.view.impl.activity.screen

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import ru.mos.app.R

class  FeedbackScreen : Screen<FeedbackScreen>() {
    //val title = KTextView {withText(R.string.feedback)}
    //val emailField = KEditText {withId(R.id.activity_feedback_email)}
    //val themesDropDown = KButton {withId(R.id.activity_feedback_title)}
    //val messageField = KEditText {withId(R.id.activity_feedback_text)}
    //val sendButton = KButton {withId(R.id.activity_feedback_send)}
    val rulesLink = KButton {withText(R.string.feedback_rules)}
    val rulesTitle = KTextView {withId(R.id.activity_feedback_description)}

    fun checkDropdownList() {
        onView(withText("Отзыв о работе"))
                .check(matches(isDisplayed()))
        onView(withText("Сообщение об ошибке"))
                .check(matches(isDisplayed()))
        onView(withText("Предложение авторам"))
                .check(matches(isDisplayed()))
        onView(withText("Другое"))
                .check(matches(isDisplayed()))
    }

    fun checkFilledEmail(email : String) {
        onView(withText(email))
                .check(matches(isDisplayed()))
    }
}