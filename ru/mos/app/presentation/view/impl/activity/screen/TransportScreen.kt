package ru.mos.app.presentation.view.impl.activity.screen

import android.widget.FrameLayout
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.kaspersky.kaspresso.testcases.core.testcontext.BaseTestContext
import org.hamcrest.Matchers
import org.hamcrest.Matchers.allOf
import ru.mos.app.R
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.testData.UserData
import ru.mos.app.presentation.view.impl.activity.utils.NestedScrollViewExtension

class  TransportScreen : Screen<TransportScreen>() {

    private val emptyFieldAlert = "Заполните обязательные поля "
    private val wrongFieldAlert = "Неверные данные в полях "

    val title = KTextView {withText(R.string.profile_transport)}
    val serviceEmptyInfo = KTextView {withText(R.string.profile_service_empty_description)}
    val driverLicense = KTextView {withText(R.string.fab_menu_transport_license)}
    val vehicle = KTextView {withText(R.string.fab_menu_transport)}
    val saveButton = KButton {withText(R.string.save)}
    val addedServiceMenu = KButton {withId(R.id.img_more)}
    val deleteButton = KTextView {withText(R.string.profile_service_delete)}
    val applyDeleteButton = KTextView {withText(R.string.proceed)}

//    fun fillFields(field : Map<String, String>) {
//
//    }

    /**
     * Старый варинат
     */
    /*
    fun fillLicenseField(number : String) {
        onView(BaseTest.hasInputHintText("Водительское удостоверение"))
                .check(matches(isDisplayed()))
                //.perform(replaceText(number))
                .perform(replaceText("7721533367"))
    }
     */

    /**
     * Новый вариант
     */
    fun BaseTestContext.fillLicenseField(user : UserData) {
        onView(BaseTest.hasInputHintText("Водительское удостоверение"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(replaceText(user.driverLicenseNumber))
    }

    /**
     * Старый вариант
     */
/*
fun fillVehicleFields() {
        onView(BaseTest.hasInputHintText("Название"))
                .perform(replaceText("Машина эвакуированная - У232ЕК99"))
        onView(BaseTest.hasInputHintText("Госномер ТС"))
                .perform(replaceText("У232ЕК99"))
        onView(BaseTest.hasInputHintText("Свидетельство ТС"))
                .perform(replaceText("7730252287"))
    }
 */
    /**
     * Новый вариант
     */
    fun BaseTestContext.fillVehicleFields(user: UserData) {
        onView(BaseTest.hasInputHintText("Название"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(replaceText("Машина эвакуированная - У232ЕК99"))
        onView(BaseTest.hasInputHintText("Госномер ТС"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(replaceText("У232ЕК99"))
        onView(BaseTest.hasInputHintText("Свидетельство ТС"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(replaceText("7730252287"))
    }

    /**
     * Старый вариант
     */
    /*
    fun fillInvalidLicenseField() {
        onView(BaseTest.hasInputHintText("Водительское удостоверение"))
                .check(matches(isDisplayed()))
                .perform(replaceText("nevalidno"))
    }
     */


    /**
     * Новый вариант
     */
    fun BaseTestContext.fillInvalidLicenseField() {
        onView(BaseTest.hasInputHintText("Водительское удостоверение"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(replaceText("nevalidno"))
    }
    /*
    fun BaseTestContext.fillLicenseField(user : UserData) {
        onView(BaseTest.hasInputHintText("Водительское удостоверение"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(replaceText(user.driverLicenseNumber))
    }
     */


    fun fillVehicleNameField() {
        onView(BaseTest.hasInputHintText("Название"))
                .perform(replaceText("Машина эвакуированная - У232ЕК99"))
    }

    fun fillVehicleNumberCertificate() {
        onView(BaseTest.hasInputHintText("Госномер ТС"))
                .perform(replaceText("11111111111"), ViewActions.closeSoftKeyboard())
        onView(BaseTest.hasInputHintText("Свидетельство ТС"))
                .perform(replaceText("11111111111"), ViewActions.closeSoftKeyboard())
    }

    fun fillVehicleInvalidNumber() {
        onView(BaseTest.hasInputHintText("Название"))
                .perform(replaceText("Машина эвакуированная - У232ЕК99"))
        onView(BaseTest.hasInputHintText("Свидетельство ТС"))
                .perform(replaceText("7730252287"))
        onView(BaseTest.hasInputHintText("Госномер ТС"))
                .perform(replaceText("nevalidno"))
    }

    fun fillVehicleInvalidCertificate() {
        onView(BaseTest.hasInputHintText("Название"))
                .perform(replaceText("Машина эвакуированная - У232ЕК99"))
        onView(BaseTest.hasInputHintText("Свидетельство ТС"))
                .perform(replaceText("nevalidno"))
        onView(BaseTest.hasInputHintText("Госномер ТС"))
                .perform(replaceText("У232ЕК99"))
    }

    fun clickToServiceMenu() {
        onView(allOf(BaseTest.childAtPosition(withId(R.id.fab_menu), 2), isDisplayed()))
                .perform(click())
        BaseTest.waitViewShown(withText(R.string.fab_menu_transport_license))
    }

    fun checkWrongFieldsAlert(field : String) {
        BaseTest.waitViewShown(withText(wrongFieldAlert + field))
    }

    fun checkEmptyFieldsAlert(field : String) {
        BaseTest.waitViewShown(withText(emptyFieldAlert + field))
    }

    fun checkVehicleFields() {
        onView(BaseTest.hasInputHintText("Название"))
                .check(matches(isDisplayed()))
        onView(BaseTest.hasInputHintText("Госномер ТС"))
                .check(matches(isDisplayed()))
        onView(BaseTest.hasInputHintText("Свидетельство ТС"))
                .check(matches(isDisplayed()))
        onView(withText(R.string.save))
                .check(matches(isDisplayed()))
    }

    fun deleteDriverLicense() {
//        BaseTest.waitViewEnabled(withText("Транспорт"))
        BaseTest.shouldBeDisplayed(withText("7721533367"))

        onView(withId(R.id.img_more))
                .check(matches(isDisplayed()))
                .perform(click())
        onView(withText(R.string.profile_service_delete))
                .check(matches(isDisplayed()))
                .perform(click())
        onView(withText(R.string.proceed))
                .check(matches(isDisplayed()))
                .perform(click())

    }
}