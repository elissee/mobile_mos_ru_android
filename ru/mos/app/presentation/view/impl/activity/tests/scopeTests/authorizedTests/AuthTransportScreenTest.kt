package ru.mos.app.presentation.view.impl.activity.tests.scopeTests.authorizedTests

import androidx.test.espresso.matcher.ViewMatchers
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.screen.Screen.Companion.onScreen
import org.junit.Test
import ru.mos.app.R
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.screen.MainScreen
import ru.mos.app.presentation.view.impl.activity.utils.NestedScrollViewExtension
import ru.mos.app.presentation.view.impl.activity.screen.ProfileScreen
import ru.mos.app.presentation.view.impl.activity.screen.ServiceScreen
import ru.mos.app.presentation.view.impl.activity.screen.TransportScreen
import ru.mos.app.presentation.view.impl.activity.testData.UserData

class AuthTransportScreenTest : BaseTest() {

    var user = UserData("phone")

    @Test
    fun testTransportScreenExit() {
        run {

            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(ViewMatchers.withText(user.name))
            }

            step("Нажать на 'Транспорт'") {
                onScreen<ProfileScreen> {
                    transport {
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
                    waitViewShown(ViewMatchers.withText(R.string.profile_my_home))
                }
            }
        }
    }

    @Test
    fun testVehicleScreenExit() {
        run {

            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(ViewMatchers.withText(user.name))
            }

            step("Нажать на 'Транспорт'") {
                onScreen<ProfileScreen> {
                    transport {
                        isEnabled()
                        //act {
                        //    NestedScrollViewExtension()
                        //}
                        click()
                    }
                }
            }

            step("Нажать на кнопку добавления ТС/ВУ") {
                onScreen<TransportScreen> {
                    clickToServiceMenu()
                }
            }

            step("Нажать на 'Транспортное средство'") {
                onScreen<TransportScreen> {
                    vehicle {
                        isDisplayed()
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
                onScreen<TransportScreen> {
                    title {
                        isEnabled()
                    }
                }
            }
        }
    }

    @Test
    fun testDriverLicenseInvalidField() {
        run {

            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(ViewMatchers.withText(user.name))
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
                onScreen<TransportScreen> {
                    serviceEmptyInfo {
                        isDisplayed()
                    }
                }
            }

            step("Нажать на кнопку добавления ТС/ВУ") {
                onScreen<TransportScreen> {
                    clickToServiceMenu()
                }
            }

            step("Нажать на 'Водительское удостоверение'") {
                onScreen<TransportScreen> {
                    driverLicense {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Ввести невалидные данные в поля") {
                onScreen<TransportScreen> {
                    //driverLicense.isEnabled()
                    fillInvalidLicenseField()
                }
            }

            step("Нажать кнопку \"Сохранить\"") {
                onScreen<TransportScreen> {
                    saveButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Проверить наличие алерта") {
                onScreen<TransportScreen> {
                    checkWrongFieldsAlert("\"Водительское удостоверение\".")
                }
            }
        }
    }

    @Test
    fun testVehicleEmptyFields() {
        run {

            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(ViewMatchers.withText(user.name))
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
                onScreen<TransportScreen> {
                    serviceEmptyInfo {
                        isDisplayed()
                    }
                }
            }

            step("Нажать на кнопку добавления ТС/ВУ") {
                onScreen<TransportScreen> {
                    clickToServiceMenu()
                }
            }

            step("Нажать на 'Транспортное средство'") {
                onScreen<TransportScreen> {
                    vehicle {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать кнопку \"Сохранить\"") {
                onScreen<TransportScreen> {
                    saveButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Проверить наличие алерта") {
                onScreen<TransportScreen> {
                    checkEmptyFieldsAlert("\"Транспортное средство\", \"Госномер ТС\", \"Свидетельство ТС\".")
                }
            }
        }
    }

    @Test
    fun testVehicleEmptyCertificateNumber() {
        run {

            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(ViewMatchers.withText(user.name))
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
                onScreen<TransportScreen> {
                    serviceEmptyInfo {
                        isDisplayed()
                    }
                }
            }

            step("Нажать на кнопку добавления ТС/ВУ") {
                onScreen<TransportScreen> {
                    clickToServiceMenu()
                }
            }

            step("Нажать на 'Транспортное средство'") {
                onScreen<TransportScreen> {
                    vehicle {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Ввести валидные данные в поле 'Название'") {
                onScreen<TransportScreen> {
                    fillVehicleNameField()
                }
            }

            step("Нажать кнопку \"Сохранить\"") {
                onScreen<TransportScreen> {
                    saveButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Проверить наличие алерта") {
                onScreen<TransportScreen> {
                    checkEmptyFieldsAlert("\"Госномер ТС\", \"Свидетельство ТС\".")
                }
            }
        }
    }

    @Test
    fun testVehicleEmptyName() {
        run {

            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
                    openProfileScreen(user, onboardingScreenState)
                }
                shouldBeDisplayed(ViewMatchers.withText(user.name))
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
                onScreen<TransportScreen> {
                    serviceEmptyInfo {
                        isDisplayed()
                    }
                }
            }

            step("Нажать на кнопку добавления ТС/ВУ") {
                onScreen<TransportScreen> {
                    clickToServiceMenu()
                }
            }

            step("Нажать на 'Транспортное средство'") {
                onScreen<TransportScreen> {
                    vehicle {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Ввести валидные данные в поле \"Госномер ТС\" и \"Свидетельство ТС\"") {
                onScreen<TransportScreen> {
                    fillVehicleNumberCertificate()
                }
            }

            step("Нажать кнопку \"Сохранить\"") {
                onScreen<TransportScreen> {
                    saveButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Проверить наличие алерта") {
                onScreen<TransportScreen> {
                    checkEmptyFieldsAlert("\"Транспортное средство\".")
                }
            }
        }
    }

    @Test
    fun testVehicleInvalidNumber() {
        run {

            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
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
                onScreen<TransportScreen> {
                    serviceEmptyInfo {
                        isDisplayed()
                    }
                }
            }

            step("Нажать на кнопку добавления ТС/ВУ") {
                onScreen<TransportScreen> {
                    clickToServiceMenu()
                }
            }

            step("Нажать на 'Транспортное средство'") {
                onScreen<TransportScreen> {
                    vehicle {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Ввести валидные данные в поле \"Название\" и \"Свидетельство ТС\" " +
                    "и невалидные данные в поле \"Госномер ТС\"") {
                onScreen<TransportScreen> {
                    fillVehicleInvalidNumber()
                }
            }

            step("Нажать кнопку \"Сохранить\"") {
                onScreen<TransportScreen> {
                    saveButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Проверить наличие алерта") {
                onScreen<TransportScreen> {
                    checkWrongFieldsAlert("\"Госномер ТС\".")
                }
            }
        }
    }

    @Test
    fun testVehicleInvalidCertificate() {
        run {

            step("Открыть Личный кабинет") {
                onScreen<MainScreen> {
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
                onScreen<TransportScreen> {
                    serviceEmptyInfo {
                        isDisplayed()
                    }
                }
            }

            step("Нажать на кнопку добавления ТС/ВУ") {
                onScreen<TransportScreen> {
                    clickToServiceMenu()
                }
            }

            step("Нажать на 'Транспортное средство'") {
                onScreen<TransportScreen> {
                    vehicle {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Ввести валидные данные в поле \"Название\" и \"Госномер ТС\" " +
                    "и невалидные данные в поле \"Свидетельство ТС\"") {
                onScreen<TransportScreen> {
                    fillVehicleInvalidCertificate()
                }
            }

            step("Нажать кнопку \"Сохранить\"") {
                onScreen<TransportScreen> {
                    saveButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Проверить наличие алерта") {
                onScreen<TransportScreen> {
                    checkWrongFieldsAlert("\"Свидетельство ТС\".")
                }
            }
        }
    }
}