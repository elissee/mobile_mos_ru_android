package ru.mos.app.presentation.view.impl.activity.screen

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.kaspersky.kaspresso.testcases.core.testcontext.BaseTestContext
import ru.mos.app.R
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.utils.NestedScrollViewExtension
import ru.mos.app.presentation.view.impl.activity.testData.UserData

class PolicyScreen : Screen<PolicyScreen>() {

    val saveButton = KButton {withText(R.string.save)}
    val policyCheckButton = KButton {
        withText(R.string.profile_service_check_oms)
        isDisplayed()
    }
    val omsNotFindAlert = KTextView {withText("Указанный полис ОМС не найден.")}
    val wrongFullnameAlert = KTextView {withText("Неверные данные в полях \"Фамилия\", \"Имя\", \"Отчество\".")}
    //val emptyFieldAlert = KTextView {withText("Заполните обязательные поля \"Фамилия\", " +
    //        "\"Имя\", \"Отчество\", \"Полис ОМС\", \"Дата рождения\".")}
    val emptyFieldAlert = KTextView {withText("Заполните обязательные поля \"Фамилия\", \"Имя\", \"Полис ОМС\", \"Дата рождения\".")}

    /**
     * Старый вариант
     */
    /*
    fun fillFields(user : UserData) {
        BaseTest.waitViewEnabled(withText("Полис"))
        onView(BaseTest.hasInputHintText("Фамилия"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(replaceText("валидов"))
        onView(BaseTest.hasInputHintText("Имя"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(replaceText("валид"))
        onView(BaseTest.hasInputHintText("Отчество"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(replaceText("валидович"))
        onView(BaseTest.hasInputHintText("Полис ОМС"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(replaceText(user.policy1))
        onView(BaseTest.hasInputHintText("Дата рождения"))
                .check(ViewAssertions.matches(ViewMatchers.isEnabled()))
                .perform(NestedScrollViewExtension(),replaceText(user.birthDate1))
    }
     */
    /**
     * Новый вариант
     */
    fun BaseTestContext.fillFields(user : UserData) {
        //onView(BaseTest.hasInputHintText("Полис"))
                //.perform(ViewActions.click())
        //BaseTest.waitViewEnabled(ViewMatchers.withText("Полис"))
        onView(BaseTest.hasInputHintText("Фамилия"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(replaceText("валидов"))
        onView(BaseTest.hasInputHintText("Имя"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(replaceText("валид"))
        onView(BaseTest.hasInputHintText("Отчество"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(replaceText("валидович"))
        onView(BaseTest.hasInputHintText("Полис ОМС"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(replaceText(user.policy1))
        onView(BaseTest.hasInputHintText("Дата рождения"))
                .check(ViewAssertions.matches(ViewMatchers.isEnabled()))
                .perform(NestedScrollViewExtension(),replaceText(user.birthDate1))
    }

    fun changeFields(user : UserData) {
        //BaseTest.waitViewEnabled(ViewMatchers.withText("Полис"))
        onView(BaseTest.hasInputHintText("Фамилия"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(ViewActions.replaceText("изменение"))
        onView(BaseTest.hasInputHintText("Имя"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(ViewActions.replaceText("полиса"))
        onView(BaseTest.hasInputHintText("Отчество"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(ViewActions.replaceText("омс"))
        onView(BaseTest.hasInputHintText("Полис ОМС"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(ViewActions.replaceText(user.policy2))
        onView(BaseTest.hasInputHintText("Дата рождения"))
                .check(ViewAssertions.matches(ViewMatchers.isEnabled()))
                .perform(NestedScrollViewExtension(), ViewActions.replaceText(user.birthDate2))
    }

    fun fillWithInvalidOms() {
        onView(BaseTest.hasInputHintText("Фамилия"))
                .perform(replaceText("валидов"))
        onView(BaseTest.hasInputHintText("Имя"))
                .perform(replaceText("валид"))
        onView(BaseTest.hasInputHintText("Отчество"))
                .perform(replaceText("валидович"))
        onView(BaseTest.hasInputHintText("Полис ОМС"))
                .perform(replaceText("12345678910111"))
        onView(BaseTest.hasInputHintText("Дата рождения"))
                .perform(NestedScrollViewExtension(), replaceText("01-01-2099"))
    }

    fun fillWithInvalidFullname() {
        //BaseTest.waitViewEnabled(withText("Полис"))
        onView(BaseTest.hasInputHintText("Фамилия"))
                .perform(replaceText("nevalidov"))
        onView(BaseTest.hasInputHintText("Имя"))
                .perform(replaceText("nevalid"))
        onView(BaseTest.hasInputHintText("Отчество"))
                .perform(replaceText("nevalidovich"))
        onView(BaseTest.hasInputHintText("Полис ОМС"))
                .perform(replaceText("12345678910111"))
        onView(BaseTest.hasInputHintText("Дата рождения"))
                .perform(NestedScrollViewExtension(), replaceText("01-01-2099"))
    }
}