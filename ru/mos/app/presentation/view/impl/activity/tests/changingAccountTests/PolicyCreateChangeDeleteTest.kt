package ru.mos.app.presentation.view.impl.activity.tests.changingAccountTests

import android.Manifest
import android.os.SystemClock
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.FlakyTest
import androidx.test.rule.GrantPermissionRule
import com.agoda.kakao.screen.Screen
import org.junit.Rule
import org.junit.Test
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.screen.MainScreen
import ru.mos.app.presentation.view.impl.activity.utils.NestedScrollViewExtension
import ru.mos.app.presentation.view.impl.activity.screen.PolicyScreen
import ru.mos.app.presentation.view.impl.activity.screen.ProfileScreen
import ru.mos.app.presentation.view.impl.activity.screen.ServiceScreen
import ru.mos.app.presentation.view.impl.activity.testData.UserData

class PolicyCreateChangeDeleteTest : BaseTest() {

    val user = UserData("phone")

    @get:Rule
    val runtimePermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    )


    @Test
    @FlakyTest
    fun testCreateDeletePolicy() {
        run {

            step("Открыть Личный кабинет") {
                Screen.onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
            }

            step("Нажать на 'Полисы ОМС'") {
                Screen.onScreen<ProfileScreen> {
                    policyOms {
                        isDisplayed()
                        click()
                    }
                }
            }

            step( "Проверить, что добавленных полисов нет") {
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

            step("В поля 'ФИО', 'Полис ОМС', 'Дата рождения' ввести валидные данные; " +
                    "нажать кнопку 'Сохранить'") {
                Screen.onScreen<PolicyScreen> {
                    fillFields(user)
                    saveButton {
                        isEnabled()
                        act {
                            NestedScrollViewExtension()
                        }
                        flakySafely(LONG_DELAY) { click() }
                    }
                }
            }

            step("Нажать на созданный полис") {
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
                Screen.onScreen<PolicyScreen> {
                    changeFields(user)
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

            for (i in 1..3) {
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

            step( "Проверить, что добавленных полисов нет") {
                Screen.onScreen<ServiceScreen> {
                    elementNotExistText {
                        flakySafely(SHORT_DELAY) { isDisplayed() }
                    }
                }
            }
        }
    }
}