package ru.mos.app.presentation.view.impl.activity.tests.scopeTests.notAuthorizedTests

import androidx.test.espresso.action.ViewActions
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
import ru.mos.app.presentation.view.impl.activity.testData.UserData

@RunWith(AndroidJUnit4::class)
class NotAuthFeedbackScreenTest : BaseTest() {

    internal var user = UserData("phone")


    @Test
    fun testInvalidEmail() {
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
                    feedback {
                        act {
                            NestedScrollViewExtension()
                        }
                        isDisplayed()
                        click()
                    }
                }
            }

            /*step("Ввести невалидные данные в поле 'Email' и проверить, что кнопка 'Отправить' неактивна") {
                onScreen<FeedbackScreen> {
                    emailField {
                        isDisplayed()
                        replaceText("nevalidno")
                        ViewActions.closeSoftKeyboard()
                    }
                    sendButton {
                        isDisabled()
                    }
                }
            }

            step("Нажать на 'Обратная связь' и проверить наличие выпадающего списка") {
                onScreen<FeedbackScreen> {
                    themesDropDown {
                        isDisplayed()
                        flakySafely(1000) {click()}
                    }
                    checkDropdownList()
                }
            }
        }
    }

    @Test
    fun  testValidEmail() {
        run {

            step("Нажать на 'О приложении'") {
                onScreen<MainScreen> {
                    feedback {
                        act {
                            NestedScrollViewExtension()
                        }
                        isDisplayed()
                        click()
                    }
                }
            }
            step("Ввести текст в поле'Сообщение'") {
                onScreen<FeedbackScreen> {
                    messageField {
                        isDisplayed()
                        typeText("text")
                        act {
                            ViewActions.closeSoftKeyboard()
                        }
                    }
                }
            }

            step("Ввести валидные данные в поля 'Email' и  проверить, что кнопка 'Отправить' активна") {
                onScreen<FeedbackScreen> {
                    emailField {
                        isDisplayed()
                        replaceText("validno@example.com")
                        act {
                            ViewActions.closeSoftKeyboard()
                        }
                    }
                    sendButton {
                        isEnabled()
                    }
                }
            }*/
        }
    }
}