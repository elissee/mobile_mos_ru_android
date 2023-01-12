package ru.mos.app.presentation.view.impl.activity.tests.scopeTests.authorizedTests

import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.agoda.kakao.screen.Screen.Companion.onScreen
import org.junit.Test
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.screen.MainScreen
import ru.mos.app.presentation.view.impl.activity.utils.NestedScrollViewExtension
import ru.mos.app.presentation.view.impl.activity.screen.ProfileScreen
import ru.mos.app.presentation.view.impl.activity.screen.SecurityScreen
import ru.mos.app.presentation.view.impl.activity.testData.UserData

class AuthSecurityScreenTest : BaseTest() {

    var user = UserData("phone")

    @Test
    fun testSecurityScreen() {
        run {

            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
            }

            step("Нажать на 'Безопасность'") {
                onScreen<ProfileScreen> {
                    security {
                        isEnabled()
                        //act {
                        //    NestedScrollViewExtension()
                        //}
                        click()
                    }
                }
            }

            step("Проверить наличие текста \"Защита при входе\" и соответствующего свитча") {
                onScreen<SecurityScreen> {
                    securityOnEntryText {
                        isDisplayed()
                    }
                    securitySwitch {
                        isDisplayed()
                        isNotChecked()
                    }
                }
            }

            step("Проверить наличие хинта \"Входить в приложение с помощью кода\"") {
                onScreen<SecurityScreen> {
                    securityInfo {
                        isDisplayed()
                    }
                }
            }
        }
    }

    @Test
    fun testCodeEntry() {
        run {

            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
            }
            step("Нажать на 'Безопасность'") {
                onScreen<ProfileScreen> {
                    security {
                        isEnabled()
                        //act {
                        //    NestedScrollViewExtension()
                        //}
                        click()
                    }
                }
            }

            step("Переключить свитч \"Защита при входе\" в активное состояние") {
                onScreen<SecurityScreen> {
                    securitySwitchBlock {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("На экране \"Введите код входа\" ввести код 12345") {
                onScreen<SecurityScreen> {
                    entryCodeTitle {
                        isDisplayed()
                    }
                    setCodeEntry("1", "2", "3", "4", "5")
                }
            }

            step("На экране \"Повторите код входа\" повторить ввод кода 12345") {
                onScreen<SecurityScreen> {
                    confirmCodeTitle {
                        isDisplayed()
                    }
                    setCodeEntry("1", "2", "3", "4", "5")
                }
            }

            step("Проверить наличие элементов:" +
                    " 'Не блокировать в течение 3-х минут' и 'Сменить код входа'") {
                onScreen<SecurityScreen> {
                    blockInterval {
                        isDisplayed()
                    }
                    changeCode {
                        isDisplayed()
                    }
                }
            }

            step("Проверить наличие текста 'Использовать вход по отпечатку пальца'") {
                onScreen<SecurityScreen> {
                    useFingerprint {
                        isDisplayed()
                    }
                }
            }
        }
    }
}