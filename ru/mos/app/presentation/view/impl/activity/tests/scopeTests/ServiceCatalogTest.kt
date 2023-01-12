package ru.mos.app.presentation.view.impl.activity.tests.scopeTests

import androidx.test.rule.ActivityTestRule
import com.agoda.kakao.screen.Screen
import org.junit.Rule
import org.junit.Test
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.categories.FavoriteServicesCatalogActivity
import ru.mos.app.presentation.view.impl.activity.screen.MainScreen
import ru.mos.app.presentation.view.impl.activity.utils.NestedScrollViewExtension
import ru.mos.app.presentation.view.impl.activity.screen.RepairOfScreen
import ru.mos.app.presentation.view.impl.activity.screen.ServiceCatalogScreen

class ServiceCatalogTest : BaseTest () {

    @Test
    fun testCatalog() {
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

            step("Нажать на 'Каталог услуг'") {
                Screen.onScreen<MainScreen> {
                    serviceCatalog {
                        flakySafely(LONG_DELAY, allowedExceptions = allowedExceptions) { isEnabled() }
                        act { NestedScrollViewExtension() }
                        click()
                    }


                    step("Нажать на 'Все сервисы mos.ru'") {
                        Screen.onScreen<ServiceCatalogScreen> {
                            //todo: не скроллит до элемента Все сервисы mos.ru. Нужен работающий костыль
                            allservices {
                                flakySafely(10000, 1000, allowedExceptions = allowedExceptions) {
                                    click() }

                            }
                        }
                    }

                    step("Нажать стрелку 'Назад'") {
                        Screen.onScreen<RepairOfScreen> {
                            backButton {
                                isDisplayed()
                                click()
                            }
                        }
                    }
                    step("Нажать стрелку 'Назад'") {
                        Screen.onScreen<RepairOfScreen> {
                            backButton {
                                isDisplayed()
                                click()
                            }
                        }
                    }
                }
            }
        }
    }
}