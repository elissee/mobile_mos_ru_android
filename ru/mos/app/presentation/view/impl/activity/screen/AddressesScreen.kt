package ru.mos.app.presentation.view.impl.activity.screen

import android.os.SystemClock
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.kaspersky.kaspresso.testcases.core.testcontext.BaseTestContext
import ru.mos.app.R
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.BaseTest.Static.hasInputHintText
import ru.mos.app.presentation.view.impl.activity.BaseTest.Static.waitViewShown
import ru.mos.app.presentation.view.impl.activity.testData.UserData

class  AddressesScreen : Screen<AddressesScreen>() {

    val saveButton = KButton {withText(R.string.save)}

    val emptyFieldAlert = "Заполните обязательные поля "
    val invalidFieldsAlert = "Неверные данные в полях "
    val wrongAddressAlert = "Введен некорректный адрес, пожалуйста, попробуйте снова"
    val mismatchNumberCode = "Номер квартиры не соответствует указанному коду плательщика. " +
            "Пожалуйста, проверьте корректность вводимых данных."

    fun BaseTestContext.validFillAllFields(user : UserData) {
        onView(BaseTest.hasInputHintText("Адрес"))
                .perform(ViewActions.click())
        onView(ViewMatchers.withId(R.id.autocomplete_text_view))
                .perform(replaceText("го"))
        SystemClock.sleep(BaseTest.SHORT_DELAY)
        BaseTest.shouldBeDisplayed(ViewMatchers.withText("город Москва, 1-й Голутвинский переулок, дом 1"))
        onView(ViewMatchers.withText("город Москва, 1-й Голутвинский переулок, дом 1"))
                .perform(flakySafely(BaseTest.LONG_DELAY) { ViewActions.click() }, ViewActions.closeSoftKeyboard())
        onView(BaseTest.hasInputHintText("Название квартиры"))
                .perform(replaceText("валидно"))
        onView(BaseTest.hasInputHintText("Номер квартиры"))
                .perform(flakySafely(BaseTest.LONG_DELAY) { replaceText(user.apartmentNumber) })
        onView(BaseTest.hasInputHintText("Код плательщика"))
                .perform(replaceText(user.payerCode))
    }

    fun fillApartmentName() {
        onView(BaseTest.hasInputHintText("Название квартиры"))
                .check(matches(isDisplayed()))
                .perform(replaceText("валидно"))
    }

    fun fillWithEmptyNumberCode() {
        onView(hasInputHintText("Название квартиры"))
                .perform(replaceText("валидно"))
        onView(hasInputHintText("Адрес"))
                .perform(replaceText("город Москва, город Троицк, микрорайон \"В\", дом 23"))
    }

    fun fillWithEmptyCode() {
        onView(hasInputHintText("Название квартиры"))
                .perform(replaceText("валидно"))
        onView(hasInputHintText("Адрес"))
                .perform(replaceText("город Москва, город Троицк, микрорайон \"В\", дом 23"))
        onView(hasInputHintText("Номер квартиры"))
                .perform(replaceText("123"))
    }

    fun fillWithEmptyNumber() {
        onView(hasInputHintText("Название квартиры"))
                .perform(replaceText("валидно"))
        onView(hasInputHintText("Адрес"))
                .perform(replaceText("город Москва, город Троицк, микрорайон \"В\", дом 23"))
        onView(hasInputHintText("Код плательщика"))
                .perform(replaceText("11111"))
    }

    fun fillWithEmptyName() {
        onView(hasInputHintText("Номер квартиры"))
                .perform(replaceText("123"))
        onView(hasInputHintText("Адрес"))
                .perform(replaceText("город Москва, город Троицк, микрорайон \"В\", дом 23"))
        onView(hasInputHintText("Код плательщика"))
                .perform(replaceText("11111"))
    }

    fun fillWithEmptyAddress() {
        onView(hasInputHintText("Название квартиры"))
                .perform(replaceText("валидно"))
        onView(hasInputHintText("Номер квартиры"))
                .perform(replaceText("123"))
        onView(hasInputHintText("Код плательщика"))
                .perform(replaceText("11111"))
    }

    fun fillWithInvalidCode() {
        onView(hasInputHintText("Название квартиры"))
                .perform(replaceText("валидно"))
        onView(hasInputHintText("Адрес"))
                .perform(replaceText("город Москва, город Троицк, микрорайон \"В\", дом 23"))
        onView(hasInputHintText("Номер квартиры"))
                .perform(replaceText("69"))
        onView(hasInputHintText("Код плательщика"))
                .perform(replaceText("невалидно"))
    }

    fun fillWithInvalidNumber() {
        onView(hasInputHintText("Название квартиры"))
                .perform(replaceText("валидно"));
        onView(hasInputHintText("Адрес"))
                .perform(replaceText("город Москва, город Троицк, микрорайон \"В\", дом 23"));
        onView(hasInputHintText("Номер квартиры"))
                .perform(replaceText("691"));
        onView(hasInputHintText("Код плательщика"))
                .perform(replaceText("3420097877"));
    }

    fun BaseTestContext.fiiWithMismatchNumberCode(user: UserData) {
        onView(BaseTest.hasInputHintText("Адрес"))
                .perform(ViewActions.click())
        onView(ViewMatchers.withId(R.id.autocomplete_text_view))
                .perform(replaceText("го"))
        SystemClock.sleep(BaseTest.SHORT_DELAY)
        //BaseTest.shouldBeDisplayed(ViewMatchers.withText("город Москва, 1-й Голутвинский переулок, дом 1"))
        //onView(ViewMatchers.withText("город Москва, 1-й Голутвинский переулок, дом 1"))
        BaseTest.shouldBeDisplayed(ViewMatchers.withText("г. Москва, Гостиничный проезд, з/у 1"))
                onView(ViewMatchers.withText("г. Москва, Гостиничный проезд, з/у 1"))
                .perform(flakySafely(BaseTest.LONG_DELAY) { ViewActions.click() }, ViewActions.closeSoftKeyboard())
        onView(BaseTest.hasInputHintText("Название квартиры"))
                .perform(replaceText("валидно"))
        onView(BaseTest.hasInputHintText("Номер квартиры"))
                .perform(flakySafely(BaseTest.LONG_DELAY) { replaceText("371") })
        onView(BaseTest.hasInputHintText("Код плательщика"))
                .perform(replaceText(user.payerCode))
    }

    fun checkEmptyFieldAlert(emptyFields : String) {
        val alert = emptyFieldAlert + emptyFields
        waitViewShown(withText(alert))
    }

    fun checkWrongFieldAlert(wrongFields : String) {
        val alert = invalidFieldsAlert + wrongFields
        waitViewShown(withText(alert))
    }

    fun BaseTestContext.changeApartmentFields(user : UserData) {

        onView(BaseTest.hasInputHintText("Адрес"))
                .perform(ViewActions.click())
        onView(ViewMatchers.withId(R.id.autocomplete_text_view))
                .perform(replaceText("го"))
        SystemClock.sleep(BaseTest.SHORT_DELAY)
        onView(ViewMatchers.withText("город Москва, 1-й Голутвинский переулок, дом 1"))
                .perform(flakySafely(BaseTest.LONG_DELAY) { ViewActions.click() }, ViewActions.closeSoftKeyboard())
        onView(BaseTest.hasInputHintText("Название квартиры"))
                .perform(replaceText("изменено"))
        onView(BaseTest.hasInputHintText("Номер квартиры"))
                .perform(flakySafely(BaseTest.LONG_DELAY) { replaceText(user.apartmentNumber) })
        onView(BaseTest.hasInputHintText("Код плательщика"))
                .perform(replaceText(user.payerCode))
    }
}