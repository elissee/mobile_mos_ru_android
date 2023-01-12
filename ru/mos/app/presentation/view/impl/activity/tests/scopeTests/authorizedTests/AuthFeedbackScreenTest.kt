package ru.mos.app.presentation.view.impl.activity.tests.scopeTests.authorizedTests

import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.screen.Screen.Companion.onScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.mos.app.presentation.view.impl.activity.BaseTest
//import ru.mos.app.presentation.view.impl.activity.FeedbackActivity
import ru.mos.app.presentation.view.impl.activity.utils.NestedScrollViewExtension
import ru.mos.app.presentation.view.impl.activity.screen.FeedbackScreen
import ru.mos.app.presentation.view.impl.activity.screen.MainScreen
import ru.mos.app.presentation.view.impl.activity.screen.ProfileScreen
import ru.mos.app.presentation.view.impl.activity.testData.UserData

@RunWith(AndroidJUnit4::class)
class AuthFeedbackScreenTest : BaseTest() {

    internal var user = UserData("phone")

    //@get:Rule
    //var mFeedbackActivity = ActivityTestRule(FeedbackActivity::class.java, true, false)


    /**
    Экран "Обратная связь"
    Проверка заполненного по умолчанию поля "Email"
     */
    @Test
    fun testFilledEmail() {
        run {

            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
            }

            step("Нажать на 'Обратная связь'") {
                Screen.onScreen<ProfileScreen> {
                    feedback {
                        isEnabled()
                        //act {
                        //    NestedScrollViewExtension()
                        //}
                        click()
                    }
                }
            }

            step("Проверить, что в поле 'Email' введён email по умолчанию") {
                onScreen<FeedbackScreen> {
                    checkFilledEmail(user.email)
                }
            }
        }
    }
}