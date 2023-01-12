package ru.mos.app.presentation.view.impl.activity.tests.changingAccountTests

import com.agoda.kakao.screen.Screen
import org.junit.Test
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.screen.MainScreen
import ru.mos.app.presentation.view.impl.activity.utils.NestedScrollViewExtension
import ru.mos.app.presentation.view.impl.activity.screen.ProfileScreen
import ru.mos.app.presentation.view.impl.activity.screen.TransportScreen
import ru.mos.app.presentation.view.impl.activity.testData.UserData

class TransportCreateDeleteTest : BaseTest() {

    var user = UserData("phone")

    @Test
    fun testDriverLicenseAppend() {
        run {

            step("Открыть Личный кабинет") {
                Screen.onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
            }

            step("Нажать на 'Транспорт'") {
                Screen.onScreen<ProfileScreen> {
                    transport {
                        isEnabled()
                        //act {
                        //    NestedScrollViewExtension()
                        //}
                        click()
                    }
                }
            }

            step("Проверить, в раздел не добавлялась информация") {
                Screen.onScreen<TransportScreen> {
                    serviceEmptyInfo {
                        isDisplayed()
                    }
                }
            }

            step("Нажать на кнопку добавления ТС/ВУ") {
                Screen.onScreen<TransportScreen> {
                    clickToServiceMenu()
                }
            }

            step("Нажать на 'Водительское удостоверение'") {
                Screen.onScreen<TransportScreen> {
                    driverLicense {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Ввести валидные данные в поля") {
                Screen.onScreen<TransportScreen> {
                    //Обратить внимание, повторяется с предыдущей, но не является ей
                    //driverLicenceInput.isEnabled()
                    fillLicenseField(user)
                }
            }

            step("Нажать кнопку \"Сохранить\"") {
                Screen.onScreen<TransportScreen> {
                    saveButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Удалить созданное удостоверение") {
                Screen.onScreen<TransportScreen> {
                    addedServiceMenu {
                        flakySafely(LONG_DELAY) { isDisplayed() }
                        click()
                    }
                    deleteButton {
                        flakySafely(LONG_DELAY) { isDisplayed() }
                        click()
                    }
                    applyDeleteButton {
                        flakySafely(LONG_DELAY) { isDisplayed() }
                        click()
                    }
                }
            }

            step("Проверить, что в разделе нет добавленных сервисов") {
                Screen.onScreen<TransportScreen> {
                    serviceEmptyInfo {
                        flakySafely(LONG_DELAY) { isDisplayed() }
                    }
                }
            }
        }
    }

    @Test
    fun testVehicleAppend() {
        run {

            step("Открыть Личный кабинет") {
                Screen.onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
            }

            step("Нажать на 'Транспорт'") {
                Screen.onScreen<ProfileScreen> {
                    transport {
                        isEnabled()
                        //act {
                        //    NestedScrollViewExtension()
                        //}
                        click()
                    }
                }
            }

            step("Проверить, что в разделе нет добавленных сервисов") {
                Screen.onScreen<TransportScreen> {
                    serviceEmptyInfo {
                        isDisplayed()
                    }
                }
            }

            step("Нажать на кнопку добавления ТС/ВУ") {
                Screen.onScreen<TransportScreen> {
                    clickToServiceMenu()
                }
            }

            step("Нажать на 'Транспортное средство'") {
                Screen.onScreen<TransportScreen> {
                    vehicle {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Ввести валидные данные в поля") {
                Screen.onScreen<TransportScreen> {
                    //vehicle теперь не подходит для ввода данных ТС
                    //vehicle.isEnabled()
                    fillVehicleFields(user)
                }
            }

            step("Нажать кнопку \"Сохранить\"") {
                Screen.onScreen<TransportScreen> {
                    saveButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Удалить созданное удостоверение") {
                Screen.onScreen<TransportScreen> {
                    addedServiceMenu {
                        flakySafely(LONG_DELAY) { isDisplayed() }
                        click()
                    }
                    deleteButton {
                        flakySafely(LONG_DELAY) { isDisplayed() }
                        click()
                    }
                    applyDeleteButton {
                        flakySafely(LONG_DELAY) { isDisplayed() }
                        click()
                    }
                }
            }

            step("Проверить, что в разделе нет добавленных сервисов") {
                Screen.onScreen<TransportScreen> {
                    serviceEmptyInfo {
                        flakySafely(LONG_DELAY) { isDisplayed() }
                    }
                }
            }
        }
    }
}