package ru.mos.app.presentation.view.impl.activity.tests.scopeTests.notAuthorizedTests

import android.Manifest
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import androidx.test.runner.AndroidJUnit4
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.screen.Screen.Companion.onScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.mos.app.presentation.view.impl.activity.AboutActivity
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.utils.NestedScrollViewExtension
import ru.mos.app.presentation.view.impl.activity.screen.*
import ru.mos.app.presentation.view.impl.activity.testData.UserData

//@RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
class NotAuthAboutActivityTest : BaseTest() {

    //internal var user = UserData("phone")

    @get:Rule
    val runtimePermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    )

    @Test
    fun testDislikeButton() {
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
                    aboutApp {
                        act {
                            NestedScrollViewExtension()
                            //ViewActions.swipeUp()
                        }
                        isDisplayed()
                                click()

                        //onView(withId(android.R.id.content)).perform(ViewActions.swipeUp());
                    }
                }
            }

            step("Нажать на 'Оценить приложение'")  {
                onScreen<AboutScreen> {
                    rateAppButton {
                        isEnabled()
                        act {
                            NestedScrollViewExtension()
                        }
                        click()
                    }
                }
            }

            step("Нажать на кнопку 'Не нравится' и проверить переход на экран 'Обратая связь'") {
                onScreen<RateScreen> {
                    dislikeButton {
                        isDisplayed()
                        click()
                    }
                }
                /*onScreen<FeedbackScreen> {
                    sendButton {
                        isDisplayed()
                    }
                }
            }*/
        }
    }

    @Test
    fun testLikeButton() {
        run {

            step("Нажать на 'О приложении'") {
                onScreen<MainScreen> {
                    aboutApp {
                        act {
                            NestedScrollViewExtension()
                        }
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать на 'Оценить приложение'")  {
                onScreen<AboutScreen> {
                    rateAppButton {
                        isEnabled()
                        act {
                            NestedScrollViewExtension()
                        }
                        click()
                    }
                }
            }

            step("Нажать на кнопку 'Нравится' и проверить появление на диалогового окна") {
                onScreen<RateScreen> {
                    likeButton {
                        isDisplayed()
                        click()
                    }
                }
                onScreen<RateScreen> {
                    goToMarketPopUp {
                        isDisplayed()
                    }
                }
            }
        }
    }

    @Test
    fun testTermsOfUse() {
        run {

            step("Нажать на 'О приложении'") {
                onScreen<MainScreen> {
                    aboutApp {
                        act {
                            NestedScrollViewExtension()
                        }
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать на 'Пользовательское соглашение' и проверить") {
                onScreen<AboutScreen> {
                    agreementButton {
                        isEnabled()
                        act {
                            NestedScrollViewExtension()
                        }
                        click()
                    }
                    backButton {
                        isDisplayed()
                        click()
                    }
                }
            }

//            step("Нажать 'Рекомендовать другу'") {
//                onScreen<AboutScreen> {
//                    recommendButton {
//                        isEnabled()
//                        act {
//                            NestedScrollViewExtension()
//                        }
//                        click()
//                    }
//                }
            }
        }
    }
}