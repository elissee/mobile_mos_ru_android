package ru.mos.app.presentation.view.impl.activity.tests.scopeTests.authorizedTests

import androidx.test.espresso.matcher.ViewMatchers
import com.agoda.kakao.screen.Screen.Companion.onScreen
import org.junit.Test
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.screen.MainScreen
import ru.mos.app.presentation.view.impl.activity.utils.NestedScrollViewExtension
import ru.mos.app.presentation.view.impl.activity.screen.NotificationsScreen
import ru.mos.app.presentation.view.impl.activity.screen.OurAppsScreen
import ru.mos.app.presentation.view.impl.activity.screen.ProfileScreen
import ru.mos.app.presentation.view.impl.activity.testData.UserData

class AuthNotificationScreenTest : BaseTest() {

    var user = UserData("phone")

    @Test
    fun testNotificationsScreen() {
        run {

            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
            }

            step("Нажать на 'Главный экран и уведомления'") {
                onScreen<ProfileScreen> {
                    notifications {
                        isEnabled()
                        act {
                            NestedScrollViewExtension()
                        }
                        click()
                    }
                }
            }

            step("Проверить экраны настроек чата") {
                onScreen<NotificationsScreen> {
                    checkNotification("Медицина")
                    checkNotification("Транспорт")
                    checkNotification("Дети в школе")
                    checkNotification("Контакт-центр")
                    checkNotification("Мой дом")
                    //checkNotification("Мой район")
                }
            }

            step("Нажать на стрелку \"Назад\"") {
                onScreen<NotificationsScreen> {
                    backButton {
                        isDisplayed()
                        click()
                    }
                }
                onScreen<ProfileScreen> {
                    notifications {
                        isDisplayed()
                    }
                }
            }
        }
    }
}