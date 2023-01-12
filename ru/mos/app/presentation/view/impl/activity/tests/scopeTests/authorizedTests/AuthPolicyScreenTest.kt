package ru.mos.app.presentation.view.impl.activity.tests.scopeTests.authorizedTests

import android.Manifest
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.GrantPermissionRule
import com.agoda.kakao.screen.Screen.Companion.onScreen
import org.junit.Rule
import org.junit.Test
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.screen.MainScreen
import ru.mos.app.presentation.view.impl.activity.utils.NestedScrollViewExtension
import ru.mos.app.presentation.view.impl.activity.screen.PolicyScreen
import ru.mos.app.presentation.view.impl.activity.screen.ServiceScreen
import ru.mos.app.presentation.view.impl.activity.screen.ProfileScreen
import ru.mos.app.presentation.view.impl.activity.testData.UserData


class AuthPolicyScreenTest : BaseTest() {

    val user = UserData("phone")

    @get:Rule
    val runtimePermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    )

    @Test
    fun testPolicyCheckScreen() {
        run {

            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(ViewMatchers.withText(user.name))
            }

            step("Нажать на 'Полисы ОМС'") {
                onScreen<ProfileScreen> {
                    policyOms {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать кнопку 'Проверка полиса ОМС'") {
                onScreen<PolicyScreen> {
                    policyCheckButton {
                        isDisplayed()
                        click()
                    }
                    //todo: сделать проверку наличия в webview Проверка полиса
                    //waitViewShown(withText("Моя Москва"))
                }
            }
        }
    }

    @Test
    fun testPolicyScreenExit() {
        run {

            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(ViewMatchers.withText(user.name))
            }

            step("Нажать на 'Полисы ОМС'") {
                onScreen<ProfileScreen> {
                    policyOms {
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
                }
            }
        }
    }

    @Test
    fun testEmptyFieldsAlert() {
        run {

            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(ViewMatchers.withText(user.name))
            }

            step("Нажать на 'Полисы ОМС'") {
                onScreen<ProfileScreen> {
                    policyOms {
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

            step("Нажать 'Сохранить'") {
                onScreen<PolicyScreen> {
                    saveButton {
                        isEnabled()
                        act{
                            NestedScrollViewExtension()
                        }
                        flakySafely(LONG_DELAY) {click()}
                    }
                }
            }

            step("Проверить наличие алёрта 'Заполните обязательные поля..'") {
                onScreen<PolicyScreen> {
                    emptyFieldAlert {
                        flakySafely(LONG_DELAY) {isDisplayed()}
                    }
                }
            }
        }
    }

    @Test
    fun testInvalidOmsAlert() {
        run {

            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(ViewMatchers.withText(user.name))
            }

            step("Нажать на 'Полисы ОМС'") {
                onScreen<ProfileScreen> {
                    policyOms {
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

            step("Заполнить валидными данными поля ФИО, невалидными данными поля ОМС и ДР") {
                onScreen<PolicyScreen> {
                    fillWithInvalidOms()
                }
            }

            step("Нажать 'Сохранить'") {
                onScreen<PolicyScreen> {
                    saveButton {
                        isEnabled()
                        act{
                            NestedScrollViewExtension()
                        }
                        flakySafely(LONG_DELAY) {click()}
                    }
                }
            }

            step("Проверить наличие алёрта 'Указанный полис ОМС не найден.'") {
                onScreen<PolicyScreen> {
                    omsNotFindAlert {
                        flakySafely(LONG_DELAY) {isDisplayed()}
                    }
                }
            }
        }
    }

    @Test
    fun testInvalidFullnameAlert() {
        run {

            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(ViewMatchers.withText(user.name))
            }

            step("Нажать на 'Полисы ОМС'") {
                onScreen<ProfileScreen> {
                    policyOms {
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

            step("Заполнить невалидными данными поля ФИО, ОМС и ДР") {
                onScreen<PolicyScreen> {
                    fillWithInvalidFullname()
                }
            }

            step("Нажать 'Сохранить'") {
                onScreen<PolicyScreen> {
                    saveButton {
                        isEnabled()
                        act{
                            NestedScrollViewExtension()
                        }
                        flakySafely(LONG_DELAY) {click()}
                    }
                }
            }

            step("Проверить наличие алёрта 'Указанный полис ОМС не найден.'") {
                onScreen<PolicyScreen> {
                    wrongFullnameAlert {
                        flakySafely(LONG_DELAY) {isDisplayed()}
                    }
                }
            }
        }
    }
}