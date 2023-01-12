package ru.mos.app.presentation.view.impl.activity.tests.changingAccountTests

import android.os.SystemClock
import androidx.test.espresso.matcher.ViewMatchers
import com.agoda.kakao.screen.Screen
import org.junit.Test
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.utils.NestedScrollViewExtension
import ru.mos.app.presentation.view.impl.activity.screen.AddressesScreen
import ru.mos.app.presentation.view.impl.activity.screen.MainScreen
import ru.mos.app.presentation.view.impl.activity.screen.ProfileScreen
import ru.mos.app.presentation.view.impl.activity.screen.ServiceScreen
import ru.mos.app.presentation.view.impl.activity.testData.UserData

class ApartmentCreateChangeDeleteTest : BaseTest() {

    val user = UserData("phone")

    @Test
    fun testCreateDeleteApartment() {
        run {

            step("Открыть Личный кабинет") {
                Screen.onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
            }

            step("Нажать на 'Адреса'") {
                Screen.onScreen<ProfileScreen> {
                    addresses {
                        isDisplayed()
                        click()
                    }
                }
            }

            step( "Проверить, что добавленных квартир нет") {
                Screen.onScreen<ServiceScreen> {
                    elementNotExistText {
                        flakySafely(SHORT_DELAY) { isDisplayed() }
                    }
                }
            }

            step("Нажать кнопку 'Добавить'") {
                Screen.onScreen<ServiceScreen> {
                    addButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("В поля 'Название квартиры', 'Адрес', 'Номер квартиры', 'Код плательщика' " +
                    "ввести валидные данные; нажать кнопку 'Сохранить'") {
                Screen.onScreen<AddressesScreen> {
                    validFillAllFields(user)
                    saveButton {
                        isEnabled()
                        act {
                            NestedScrollViewExtension()
                        }
                        flakySafely(LONG_DELAY) { click() }
                    }
                }
            }

            step("Нажать на созданную квартиру") {
                Screen.onScreen<ServiceScreen> {
                    createdElement {
                        flakySafely(LONG_DELAY) { isDisplayed() }
                        flakySafely(LONG_DELAY) { click() }
                    }
                }
            }

            step("Нажать на 'Изменить'") {
                Screen.onScreen<ServiceScreen> {
                    changeButton {
                        flakySafely(LONG_DELAY) { isDisplayed() }
                        flakySafely(LONG_DELAY) { click() }
                    }
                }
            }

            step("Изменить данные 'ФИО', 'Полис ОМС', 'Дата рождения' на другие " +
                    "валидные данные; нажать на 'Сохранить'") {
                Screen.onScreen<AddressesScreen> {
                    changeApartmentFields(user)
                    saveButton {
                        isEnabled()
                        act {
                            NestedScrollViewExtension()
                        }
                        click()
                    }
                }
            }

            step("Дождаться синхронизации с сервером. Таймаут 1 минута 10 секунд") {
                SystemClock.sleep(70000)
            }


            for (i in 0..3) {
                SystemClock.sleep(LONG_DELAY)

                step("Нажать на изменённый полис") {
                    Screen.onScreen<ServiceScreen> {
                        createdElement {
                            flakySafely(LONG_DELAY) { isDisplayed() }
                            flakySafely(LONG_DELAY) { click() }
                        }
                    }
                }

                step("Нажать на 'Удалить' и подтвердить удаление нажатием на 'Продолжить'") {
                    Screen.onScreen<ServiceScreen> {
                        deleteButton {
                            flakySafely(LONG_DELAY) { isDisplayed() }
                            flakySafely(LONG_DELAY) { click() }
                        }
                        agreeDeleteButton {
                            flakySafely(LONG_DELAY) { isDisplayed() }
                            flakySafely(LONG_DELAY) { click() }
                        }
                    }
                }
                if (isElementDisplayed(ViewMatchers.withText("Ошибка"))) {

                    step("Появился алёрт 'Пожалуйста подождите. Данные синхронизируются'. Нажать на 'ОК'") {
                        Screen.onScreen<ServiceScreen> {
                            alertOkButton {
                                flakySafely(LONG_DELAY) { isDisplayed() }
                                flakySafely(LONG_DELAY) { click() }
                            }
                        }
                    }
                }
                else {
                    break
                }
            }

            step( "Проверить, что полис удалился") {
                Screen.onScreen<ServiceScreen> {
                    elementNotExistText {
                        flakySafely(BaseTest.SHORT_DELAY) { isDisplayed() }
                    }
                }
            }
        }
    }
}
