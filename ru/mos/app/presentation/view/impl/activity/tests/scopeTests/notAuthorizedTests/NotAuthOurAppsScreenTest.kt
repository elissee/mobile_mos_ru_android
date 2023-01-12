package ru.mos.app.presentation.view.impl.activity.tests.scopeTests.notAuthorizedTests

import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.screen.Screen.Companion.onScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.mos.app.presentation.view.impl.activity.AppServicesActivity
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.utils.NestedScrollViewExtension
import ru.mos.app.presentation.view.impl.activity.screen.MainScreen
import ru.mos.app.presentation.view.impl.activity.screen.OurAppsScreen
import ru.mos.app.presentation.view.impl.activity.testData.UserData

@RunWith(AndroidJUnit4::class)
class NotAuthOurAppsScreenTest : BaseTest() {

    internal val user = UserData("phone")


    @Test
    fun testAppsTitles() {
        run {

            step("Закрыть экран приветствия") {
                Screen.onScreen<MainScreen> {
                    closeWelcomeScreen()
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

            step("Нажать на 'О приложении'") {
                onScreen<MainScreen> {
                    ourApps {
                        act {
                            NestedScrollViewExtension()
                        }
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Проверить наличие приложений в списке и работоспособность ссылки на приложение") {
                onScreen<OurAppsScreen> {
                    checkApps()
                }
            }
        }
    }
}