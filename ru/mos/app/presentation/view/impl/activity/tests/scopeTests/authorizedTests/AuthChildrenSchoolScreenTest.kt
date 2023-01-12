package ru.mos.app.presentation.view.impl.activity.tests.scopeTests.authorizedTests

import androidx.test.espresso.matcher.ViewMatchers
import com.agoda.kakao.screen.Screen.Companion.onScreen
import org.junit.Test
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.screen.ChildrenSchoolScreen
import ru.mos.app.presentation.view.impl.activity.screen.MainScreen
import ru.mos.app.presentation.view.impl.activity.screen.ProfileScreen
import ru.mos.app.presentation.view.impl.activity.testData.UserData

class AuthChildrenSchoolScreenTest : BaseTest() {

    var user = UserData("phone")

    @Test
    fun testChildrenSchoolScreen() {
        run {

            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
            }

            step("Нажать на \"Дети в школе\"") {
                onScreen<ProfileScreen> {
                    childrenSchool {
                        isDisplayed()
                        click()
                    }
                }
                onScreen<ChildrenSchoolScreen> {
                    title {
                        flakySafely(SHORT_DELAY) { isEnabled() }
                    }
                }
            }

            step("Нажать стрелку \"Назад\"") {
                onScreen<ChildrenSchoolScreen> {
                    backButton {
                        isDisplayed()
                        click()
                    }
                }
                onScreen<ProfileScreen> {
                    childrenSchool {
                        flakySafely(SHORT_DELAY) { isDisplayed() }
                    }
                }
            }
        }
    }
}