package ru.mos.app.presentation.view.impl.activity.tests.scopeTests.authorizedTests

import androidx.test.espresso.matcher.ViewMatchers
import com.agoda.kakao.screen.Screen.Companion.onScreen
import org.junit.Test
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.utils.NestedScrollViewExtension
import ru.mos.app.presentation.view.impl.activity.screen.EditProfileScreen
import ru.mos.app.presentation.view.impl.activity.screen.MainScreen
import ru.mos.app.presentation.view.impl.activity.screen.ProfileScreen
import ru.mos.app.presentation.view.impl.activity.testData.UserData

class AuthProfileScreenTest : BaseTest() {

    var user = UserData("phone")

    @Test
    fun testEditProfileInfoScreen() {
        run {

            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
            }

            step("Нажать на ФИО учётной записи") {
                onScreen<ProfileScreen> {
                    clickOnName(user.name)

                }
                onScreen<EditProfileScreen> {
                    checkProfileFields(user.name)
                }
            }

            step("Нажать на кнопку 'Редактировать'") {
               onScreen<EditProfileScreen> {
                   profileEditButton {
                       isDisplayed()
                       click()
                   }
               }
            }

            step("Проверить наличие полей редактирования") {
                onScreen<EditProfileScreen> {
                    checkEditProfileFields()
                }
            }

            step("Проверить наличие кнопки Сохранить") {
                onScreen<EditProfileScreen> {
                    saveButton {
                        act {
                            NestedScrollViewExtension()
                        }
                        isDisplayed()
                    }
                }
            }

            step("Вернуться на страницу \"Мои данные\", нажав <- в навбаре") {
                onScreen<EditProfileScreen> {
                    backButton {
                        isDisplayed()
                        click()
                    }
                    profileEditButton {
                        flakySafely(SHORT_DELAY) { isDisplayed() }
                    }
                }
            }

            step("Вернуться в личный кабинет, нажав <- в навбаре") {
                onScreen<EditProfileScreen> {
                    backButton {
                        isDisplayed()
                        click()
                    }
                }
                onScreen<ProfileScreen> {
                    childrenSchool {
                        isEnabled()
                    }
                }
            }
        }
    }

}