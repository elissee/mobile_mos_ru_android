package ru.mos.app.presentation.view.impl.activity.tests.scopeTests.authorizedTests

import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.agoda.kakao.screen.Screen.Companion.onScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.mos.app.presentation.view.impl.activity.AppServicesActivity
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.screen.MainScreen
import ru.mos.app.presentation.view.impl.activity.utils.NestedScrollViewExtension
import ru.mos.app.presentation.view.impl.activity.screen.ProfileScreen
import ru.mos.app.presentation.view.impl.activity.screen.ServiceScreen
import ru.mos.app.presentation.view.impl.activity.testData.UserData

@RunWith(AndroidJUnit4::class)
class AuthOurAppsScreenTest : BaseTest() {

    internal val user = UserData("phone")

    @get:Rule
    var mAppServicesActivity = ActivityTestRule(AppServicesActivity::class.java, true, false)

    @Test
    fun testScreenExit() {
        run {

            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(ViewMatchers.withText(user.name))
            }

            step("Нажать на 'Наши приложения'") {
                onScreen<ProfileScreen> {
                    ourApps {
                        isEnabled()
                        //act {
                        //    NestedScrollViewExtension()
                        //}
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

                onScreen<ProfileScreen> {
                    ourApps {
                        flakySafely(SHORT_DELAY) { isDisplayed() }
                    }
                }
            }
        }
    }
}