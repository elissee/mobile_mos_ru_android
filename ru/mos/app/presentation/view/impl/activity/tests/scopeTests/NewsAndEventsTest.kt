package ru.mos.app.presentation.view.impl.activity.tests.scopeTests

import android.widget.Toolbar
import com.agoda.kakao.screen.Screen
import org.junit.Test
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.screen.LoginScreen
import ru.mos.app.presentation.view.impl.activity.screen.MainScreen
import ru.mos.app.presentation.view.impl.activity.screen.RepairOfScreen
import ru.mos.app.presentation.view.impl.activity.testData.UserData

class NewsAndEventsTest : BaseTest() {

    @Test
    fun testTabbar() {
        run {
            step("Закрыть экран приветствия") {
                Screen.onScreen<MainScreen> {
                    closeWelcomeScreen()
                }
            }

            step("Открыть Новости") {
                Screen.onScreen<MainScreen> {
                    news {
                        isDisplayed()
                        click()
                    }
                }
            }
            step("Открыть Платежи") {
                Screen.onScreen<MainScreen> {
                    payments {
                        isDisplayed()
                        click()
                    }
                }
            }
            step("Открыть Услуги") {
                Screen.onScreen<MainScreen> {
                    services {
                        isDisplayed()
                        click()
                    }
                }
            }
            step("Открыть Главная") {
                Screen.onScreen<MainScreen> {
                    home {
                        isDisplayed()
                        click()
                    }
                }
            }
        }
    }
}