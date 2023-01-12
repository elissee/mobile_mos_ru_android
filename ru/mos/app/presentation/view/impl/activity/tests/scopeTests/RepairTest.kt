package ru.mos.app.presentation.view.impl.activity.tests.scopeTests

import androidx.test.espresso.action.ViewActions
import androidx.test.rule.ActivityTestRule
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.screen.Screen.Companion.onScreen
import org.junit.Rule
import org.junit.Test
import ru.mos.app.presentation.view.ct.CTRequestActivity
import ru.mos.app.presentation.view.ct.CTRequestModelActivity
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.screen.MainScreen
import ru.mos.app.presentation.view.impl.activity.utils.NestedScrollViewExtension
import ru.mos.app.presentation.view.impl.activity.screen.RepairOfScreen
/*


class RepairTest : BaseTest() {

    @Test
    fun testSmart() {
        run {

            step("Открыть Услуги") {
                Screen.onScreen<MainScreen> {
                    services {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать на 'Ремонт техники'") {
                Screen.onScreen<MainScreen> {
                    repairTechnics {
                        flakySafely(allowedExceptions = allowedExceptions) { isEnabled() }
                        act { NestedScrollViewExtension() }
                        click()
                    }
                }
            }

            step("Проверка наличия смарта") {
                Screen.onScreen<RepairOfScreen> {
                    smart {
                        isDisplayed()
                        click()
                    }
                }
            }
            step("Нажать кнопку Продолжить") {
                onScreen<RepairOfScreen> {
                    cont {
                        isDisplayed()
                        click()
                    }
                }
            }
            step("Нажать стрелку 'Назад'") {
                onScreen<RepairOfScreen> {
                    backButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Проверка наличия планшета") {
                Screen.onScreen<RepairOfScreen> {
                    tablet {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать кнопку Продолжить") {
                onScreen<RepairOfScreen> {
                    cont {
                        isDisplayed()
                        click()
                    }
                }
            }
            step("Нажать стрелку 'Назад'") {
                onScreen<RepairOfScreen> {
                    backButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Проверка наличия ноутбука") {
                Screen.onScreen<RepairOfScreen> {
                    laptop {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать кнопку Продолжить") {
                onScreen<RepairOfScreen> {
                    cont {
                        isDisplayed()
                        click()
                    }
                }
            }
            step("Нажать стрелку 'Назад'") {
                onScreen<RepairOfScreen> {
                    backButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Проверка наличия моноблока") {
                Screen.onScreen<RepairOfScreen> {
                    mono {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать кнопку Продолжить") {
                onScreen<RepairOfScreen> {
                    cont {
                        isDisplayed()
                        click()
                    }
                }
            }
            step("Нажать стрелку 'Назад'") {
                onScreen<RepairOfScreen> {
                    backButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Проверка наличия десктопа") {
                Screen.onScreen<RepairOfScreen> {
                    pc {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать кнопку Продолжить") {
                onScreen<RepairOfScreen> {
                    cont {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать стрелку 'Назад'") {
                onScreen<RepairOfScreen> {
                    backButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Проверка наличия принтера") {
                Screen.onScreen<RepairOfScreen> {
                    printer {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать кнопку Продолжить") {
                onScreen<RepairOfScreen> {
                    cont {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать стрелку 'Назад'") {
                onScreen<RepairOfScreen> {
                    backButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать на ссылку 'Как сдать и получить технику'") {
                onScreen<RepairOfScreen> {
                    logo {
                        act {
                            NestedScrollViewExtension()
                        }
                    }
                    linkOne {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать стрелку 'Назад'") {
                onScreen<RepairOfScreen> {
                    backButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать на ссылку 'Кто осуществляет ремонт'") {
                onScreen<RepairOfScreen> {
                    linkTwo {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать стрелку 'Назад'") {
                onScreen<RepairOfScreen> {
                    backButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать на ссылку 'Когда производится оплата'") {
                onScreen<RepairOfScreen> {
                    linkThree {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать стрелку 'Назад'") {
                onScreen<RepairOfScreen> {
                    backButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать на ссылку 'Чудо техники'") {
                onScreen<RepairOfScreen> {
                    logo {
                        act {
                            NestedScrollViewExtension()
                        }
                    }
                    logo {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать стрелку 'Назад'") {
                onScreen<RepairOfScreen> {
                    backButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать кнопку Продолжить") {
                onScreen<RepairOfScreen> {
                    cont {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Выбор устройства") {
                Screen.onScreen<RepairOfScreen> {
                    device {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Устройство выбрано") {
                Screen.onScreen<RepairOfScreen> {
                    device1 {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Выбор устройства") {
                Screen.onScreen<RepairOfScreen> {
                    device {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Отмена выбора устройства в диалоге") {
                onScreen<RepairOfScreen> {
                    cancel {
                        click()
                    }
                }
            }

            step("Выбор бренда") {
                Screen.onScreen<RepairOfScreen> {
                    brand {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Бренд выбран") {
                Screen.onScreen<RepairOfScreen> {
                brand1 {
                    isDisplayed()
                    click()
                }
            }
        }

            step("Выбор бренда") {
                Screen.onScreen<RepairOfScreen> {
                    brand {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Отмена выбора бренда в диалоге 'Отмена'") {
                onScreen<RepairOfScreen> {
                    cancel {
                        click()
                    }
                }
            }

            step("Ввод названия модели") {
                onScreen<RepairOfScreen> {
                    modelField {
                        isDisplayed()
                        typeText("Test12345")
                        act {
                            ViewActions.closeSoftKeyboard()
                        }
                    }
                }
            }

            step("Ввод описания проблемы") {
                onScreen<RepairOfScreen> {
                    problemField {
                        isDisplayed()
                        typeText("Test")
                        act {
                            ViewActions.closeSoftKeyboard()
                        }
                    }
                }
            }

            step("Ввод имени") {
                onScreen<RepairOfScreen> {
                    nameField {
                        isDisplayed()
                        typeText("Test Test")
                        act {
                            ViewActions.closeSoftKeyboard()
                        }
                    }
                }
            }

            step("Ввод номера телефона") {
                onScreen<RepairOfScreen> {
                    phoneField {
                        isDisplayed()
                        typeText("9000000000")
                        act {
                            ViewActions.closeSoftKeyboard()
                        }
                    }
                }
            }

            step("Ввод адреса") {
                onScreen<RepairOfScreen> {
                    addressField {
                        isDisplayed()
                        typeText("Test Test Test")
                        act {
                            ViewActions.closeSoftKeyboard()
                        }
                    }
                }
            }

            step ("Нажать 'Условия'") {
                onScreen<RepairOfScreen> {
                    linkConditions {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать стрелку 'Назад'") {
                onScreen<RepairOfScreen> {
                    backButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать кнопку 'Отправить сообщение'") {
                onScreen<RepairOfScreen> {
                    send {
                        isDisplayed()
                        click()
                    }
                }
            }
        }
    }

 */

