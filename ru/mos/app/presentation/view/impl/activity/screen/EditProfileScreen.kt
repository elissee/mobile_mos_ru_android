package ru.mos.app.presentation.view.impl.activity.screen

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import ru.mos.app.R
import ru.mos.app.presentation.view.impl.activity.BaseTest

class  EditProfileScreen : Screen<EditProfileScreen>() {


    //val profileEditButton = KButton {withId(R.id.action_edit)}
    val profileEditButton = KButton {withId(R.id.btn_edit_or_fill)}
    val saveButton = KButton {withText(R.string.save)}
    val backButton = KButton {withContentDescription("Navigate up")}

    val fillProfile = KButton {withText("Заполнить профиль")}
    //val fillProfile = KButton {withId(R.id.text)}
    //val fillProfile = KTextView {withText("Заполнить профиль")}
    //val fillProfile = KTextView {withId(R.id.text)}

    fun checkProfileFields(name : String) {
        Espresso.onView(ViewMatchers.withText(R.string.first_middle_last_name))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText(R.string.phone))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun checkEditProfileFields() {
        Espresso.onView(BaseTest.hasInputHintText("ФИО"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(BaseTest.hasInputHintText("Дата рождения"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(BaseTest.hasInputHintText("СНИЛС"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(BaseTest.hasInputHintText("Телефон"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(BaseTest.hasInputHintText("Email"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        //todo: починить проверку поля ИНН
        //Espresso.onView(BaseTest.hasInputHintText("ИНН"))
        //        .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun checkEditProfileFieldsNullUser() {
        Espresso.onView(BaseTest.hasInputHintText("Фамилия"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(BaseTest.hasInputHintText("Имя"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(BaseTest.hasInputHintText("Отчество"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(BaseTest.hasInputHintText("Дата рождения"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(BaseTest.hasInputHintText("СНИЛС"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(BaseTest.hasInputHintText("Телефон"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(BaseTest.hasInputHintText("Email"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }
}