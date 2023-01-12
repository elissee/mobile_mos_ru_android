package ru.mos.app.presentation.view.impl.activity.tests.scopeTests.authorizedTests

import android.Manifest
import android.provider.ContactsContract
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.GrantPermissionRule
import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.kaspersky.kaspresso.testcases.core.testcontext.BaseTestContext
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import org.junit.Rule
import org.junit.Test
import ru.mos.app.R
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.utils.NestedScrollViewExtension
import ru.mos.app.presentation.view.impl.activity.screen.AddressesScreen
import ru.mos.app.presentation.view.impl.activity.screen.MainScreen
import ru.mos.app.presentation.view.impl.activity.screen.ProfileScreen
import ru.mos.app.presentation.view.impl.activity.screen.ServiceScreen
import ru.mos.app.presentation.view.impl.activity.testData.UserData

class AuthAddressesScreenTest : BaseTest() {

    val user = UserData("phone")

    @get:Rule
    val runtimePermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    )

    @Test
    fun testAddressesScreenExit() {
        run {
            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(withText(user.name))
            }

            step("Нажать на 'Адреса") {
                onScreen<ProfileScreen> {
                    addresses {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать стрелку 'Назад'") {
                onScreen<ServiceScreen> {
                    backButton {
                        isDisplayed()
                        click()
                    }
                    waitViewShown(withText(R.string.profile_my_home))
                }
            }

//            step("Нажать на 'Выйти'") {
//                onScreen<ProfileScreen> {
//                    logOut {
//                        act { NestedScrollViewExtension() }
//                        click()
//                    }
//                }
//            }
        }
    }

    @Test
    fun testEmptyFields() {
        run {
            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(withText(user.name))
            }

            step("Нажать на 'Адреса'") {
                onScreen<ProfileScreen> {
                    addresses {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать кнопку 'Добавить'") {
                onScreen<ServiceScreen> {
                    addButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать кнопку 'Сохранить'") {
                onScreen<AddressesScreen> {
                    saveButton {
                        isEnabled()
                        act {
                            NestedScrollViewExtension()
                        }

                        flakySafely(LONG_DELAY) { click() }
                    }
                }
            }

            step("Проверить наличие алёрта") {
                onScreen<AddressesScreen> {
                    checkEmptyFieldAlert("\"Квартира\", \"Адрес\"." //+
                            /*"\"Номер квартиры\", \"Код плательщика\"."*/)
                }
            }
        }
    }

    @Test
    fun testEmptyAddressNumberCode() {
        run {
            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(withText(user.name))
            }

            step("Нажать на 'Адреса'") {
                onScreen<ProfileScreen> {
                    addresses {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать кнопку 'Добавить'") {
                onScreen<ServiceScreen> {
                    addButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Ввести данные в 'Название квартиры' и нажать кнопку 'Сохранить'") {
                onScreen<AddressesScreen> {
                    fillApartmentName()
                    saveButton {
                        isEnabled()
                        act {
                            NestedScrollViewExtension()
                        }
                        flakySafely(LONG_DELAY) { click() }
                    }
                }
            }

            step("Проверить наличие алёрта") {
                onScreen<AddressesScreen> {
                    checkEmptyFieldAlert("\"Адрес\"." /*+ "\"Номер квартиры\", \"Код плательщика\"."*/)
                }
            }
        }
    }
    //Требуется корректировка (Исправлено)
    @Test
    fun testEmptyNumberCode() {
        run {
            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(withText(user.name))
            }

            step("Нажать на 'Адреса'") {
                onScreen<ProfileScreen> {
                    addresses {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать кнопку 'Добавить'") {
                onScreen<ServiceScreen> {
                    addButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Ввести данные в 'Название квартиры' и 'Адрес' и нажать кнопку 'Сохранить'") {
                onScreen<AddressesScreen> {
                    fillWithEmptyNumberCode()
                    saveButton {
                        isEnabled()
                        act {
                            NestedScrollViewExtension()
                        }
                        flakySafely(LONG_DELAY) { click() }
                    }
                }
            }

            step("Проверить наличие алёрта") {
                onScreen<AddressesScreen> {
                    //checkEmptyFieldAlert("\"Номер квартиры\", \"Код плательщика\".")
                    waitViewShown(withText(wrongAddressAlert))
                }
            }
        }
    }
    //Требуется корректировка (Исправлено)
    @Test
    fun testEmptyCode() {
        run {
            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(withText(user.name))
            }

            step("Нажать на 'Адреса'") {
                onScreen<ProfileScreen> {
                    addresses {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать кнопку 'Добавить'") {
                onScreen<ServiceScreen> {
                    addButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Ввести данные в 'Название квартиры', 'Номер квартиры', 'Адрес' и нажать кнопку 'Сохранить'") {
                onScreen<AddressesScreen> {
                    fillWithEmptyCode()
                    saveButton {
                        isEnabled()
                        act {
                            NestedScrollViewExtension()
                        }
                        flakySafely(LONG_DELAY) { click() }
                    }
                }
            }

            step("Проверить наличие алёрта") {
                onScreen<AddressesScreen> {
                    //checkEmptyFieldAlert("\"Код плательщика\".")
                    waitViewShown(withText(wrongAddressAlert))
                }
            }
        }
    }
    //Требуется корректировка (Исправлено)
    @Test
    fun testEmptyNumber() {
        run {
            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(withText(user.name))
            }

            step("Нажать на 'Адреса'") {
                onScreen<ProfileScreen> {
                    addresses {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать кнопку 'Добавить'") {
                onScreen<ServiceScreen> {
                    addButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Ввести данные в 'Название квартиры' и 'Адрес', 'Код плательщика' и нажать кнопку 'Сохранить'") {
                onScreen<AddressesScreen> {
                    fillWithEmptyNumber()
                    saveButton {
                        isEnabled()
                        act {
                            NestedScrollViewExtension()
                        }
                        flakySafely(LONG_DELAY) { click() }
                    }
                }
            }

            step("Проверить наличие алёрта") {
                onScreen<AddressesScreen> {
                    //checkEmptyFieldAlert("\"Номер квартиры\".")
                    //waitViewShown(withText(invalidFieldsAlert))
                    checkWrongFieldAlert("\"Код плательщика\".")
                }
            }
        }
    }

    @Test
    fun testEmptyName() {
        run {
            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(withText(user.name))
            }

            step("Нажать на 'Адреса'") {
                onScreen<ProfileScreen> {
                    addresses {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать кнопку 'Добавить'") {
                onScreen<ServiceScreen> {
                    addButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Ввести данные в 'Код плательщика' и 'Адрес', 'Номер квартиры' и нажать кнопку 'Сохранить'") {
                onScreen<AddressesScreen> {
                    fillWithEmptyName()
                    saveButton {
                        isEnabled()
                        act {
                            NestedScrollViewExtension()
                        }
                        flakySafely(LONG_DELAY) { click() }
                    }
                }
            }

            step("Проверить наличие алёрта") {
                onScreen<AddressesScreen> {
                    checkEmptyFieldAlert("\"Квартира\".")
                }
            }
        }
    }

    @Test
    fun testEmptyAddress() {
        run {
            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(withText(user.name))
            }

            step("Нажать на 'Адреса'") {
                onScreen<ProfileScreen> {
                    addresses {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать кнопку 'Добавить'") {
                onScreen<ServiceScreen> {
                    addButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Ввести данные в 'Код плательщика' и 'Название квартиры', 'Номер квартиры' и нажать кнопку 'Сохранить'") {
                onScreen<AddressesScreen> {
                    fillWithEmptyAddress()
                    saveButton {
                        isEnabled()
                        act {
                            NestedScrollViewExtension()
                        }
                        flakySafely(LONG_DELAY) { click() }
                    }
                }
            }

            step("Проверить наличие алёрта") {
                onScreen<AddressesScreen> {
                    checkEmptyFieldAlert("\"Адрес\".")
                }
            }
        }
    }

//    fun BaseTestContext.ttt() {
//        onScreen<MainScreen> {
//            openLoginScreen(onboardingScreenState)
//            if (!isAuthorized) {
//                auth(user)
//                settings {
//                    waitShown(action = { click() })
//                }
//                waitUntil(action = { isAuthorized })
////                        After { isAuthorized }.execute { screen.settings.click() }
//            }
//        }
//        shouldBeDisplayed(withText(user.name))
//    }

    @Test
    fun testInvalidCode() {
        run {
            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(withText(user.name))
            }

            step("Нажать на 'Адреса'") {
                onScreen<ProfileScreen> {
                    addresses {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать кнопку 'Добавить'") {
                onScreen<ServiceScreen> {
                    addButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Заполнить валидными данными поля 'Название квартиры', 'Адрес' и " +
                    "'Номер квартиры' и невалидными данными поле 'Код плательщика'") {
                onScreen<AddressesScreen> {
                    fillWithInvalidCode()
                    saveButton {
                        isEnabled()
                        act {
                            NestedScrollViewExtension()
                        }
                        flakySafely(LONG_DELAY) { click() }
                    }
                }
            }

            step("Проверить наличие алёрта") {
                onScreen<AddressesScreen> {
                    checkWrongFieldAlert("\"Код плательщика\".")
                }
            }
        }
    }

    @Test
    fun testInvalidNumber() {
        run {
            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(withText(user.name))
            }

            step("Нажать на 'Адреса'") {
                onScreen<ProfileScreen> {
                    addresses {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать кнопку 'Добавить'") {
                onScreen<ServiceScreen> {
                    addButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Заполнить валидными данными поля 'Название квартиры', 'Адрес' и " +
                    "'Код плательщика' и невалидными данными поле 'Номер квартиры'") {
                onScreen<AddressesScreen> {
                    fillWithInvalidNumber()
                    saveButton {
                        isEnabled()
                        act {
                            NestedScrollViewExtension()
                        }
                        flakySafely(LONG_DELAY) { click() }
                    }
                }
            }

            step("Проверить наличие алёрта") {
                onScreen<AddressesScreen> {
                    waitViewShown(withText(wrongAddressAlert))
                }
            }
        }
    }
    //Требует корректировки
    @Test
    fun testMismatchNumberCode() {
        run {
            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(withText(user.name))
            }

            step("Нажать на 'Адреса'") {
                onScreen<ProfileScreen> {
                    addresses {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать кнопку 'Добавить'") {
                onScreen<ServiceScreen> {
                    addButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Заполнить валидными данными поля 'Название квартиры', 'Адрес' и " +
                    "с валидной но не соответствующей друг другу парой полей 'Код плательщика' и 'Номер квартиры'") {
                onScreen<AddressesScreen> {
                    fiiWithMismatchNumberCode(user)
                    saveButton {
                        isEnabled()
                        act {
                            NestedScrollViewExtension()
                        }
                        flakySafely(LONG_DELAY) { click() }
                    }
                }
            }

            step("Проверить наличие алёрта") {
                onScreen<AddressesScreen> {
                    waitViewShown(withText(mismatchNumberCode))
                }
            }
        }
    }
}