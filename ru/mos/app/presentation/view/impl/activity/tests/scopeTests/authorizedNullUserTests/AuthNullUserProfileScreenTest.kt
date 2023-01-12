package ru.mos.app.presentation.view.impl.activity.tests.scopeTests.authorizedNullUserTests

import androidx.test.espresso.matcher.ViewMatchers
import com.agoda.kakao.screen.Screen.Companion.onScreen
import org.junit.Test
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.utils.NestedScrollViewExtension
import ru.mos.app.presentation.view.impl.activity.screen.EditProfileScreen
import ru.mos.app.presentation.view.impl.activity.screen.MainScreen
import ru.mos.app.presentation.view.impl.activity.screen.ProfileScreen
import ru.mos.app.presentation.view.impl.activity.testData.UserData

class AuthNullUserProfileScreenTest : BaseTest() {

    var user = UserData("phone_null")

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
            }

            step("Проверить наличие и нажать на кнопку Заполнить профиль") {
                onScreen<EditProfileScreen> {
                    fillProfile {
                        isDisplayed()
                        click()
                    }
                }

            }

            step("Проверить наличие полей редактирования") {
                onScreen<EditProfileScreen> {
                    checkEditProfileFieldsNullUser()
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
                }
            }

            step("Вернуться в личный кабинет, нажав <- в навбаре") {
                onScreen<EditProfileScreen> {
                    backButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать на Полисы ОМС") {
                onScreen<ProfileScreen> {
                    policyOms {
                        isDisplayed()
                        click()
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
            }

            step("Нажать на Адреса") {
                onScreen<ProfileScreen> {
                    addresses {
                        isDisplayed()
                        click()
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
            }

            step("Нажать на Транспорт") {
                onScreen<ProfileScreen> {
                    transport {
                        isDisplayed()
                        click()
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
            }

            step("Нажать на Дети в школе") {
                onScreen<ProfileScreen> {
                    childrenSchool {
                        isDisplayed()
                        click()
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
            }

            step("Нажать на Главный экран и уведомления") {
                onScreen<ProfileScreen> {
                    notifications {
                        isDisplayed()
                        click()
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
            }

            step("Нажать на Безопасность") {
                onScreen<ProfileScreen> {
                    security {
                        isDisplayed()
                        click()
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
            }

            step("Нажать на О приложении") {
                onScreen<ProfileScreen> {
                    aboutApp {
                        isDisplayed()
                        click()
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
            }

            step("Нажать на Обратная связь") {
                onScreen<ProfileScreen> {
                    feedback {
                        isDisplayed()
                        click()
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
            }

            step("Нажать на Наши приложения") {
                onScreen<ProfileScreen> {
                    ourApps {
                        act {
                            NestedScrollViewExtension()
                        }
                        isDisplayed()
                        click()
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
            }

            step("Нажать на Выйти") {
                onScreen<ProfileScreen> {
                    logOut {
                        act {
                            NestedScrollViewExtension()
                        }
                        isDisplayed()
                        click()
                    }
                }
            }

            //todo: реализовать логаут
        }
    }
}