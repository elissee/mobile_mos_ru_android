package ru.mos.app.presentation.view.impl.activity

import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.PerformException
import androidx.test.espresso.action.ViewActions
import com.agoda.kakao.screen.Screen.Companion.onScreen
import org.junit.Test
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.screen.ForgotPassScreen
import ru.mos.app.presentation.view.impl.activity.screen.LoginScreen
import ru.mos.app.presentation.view.impl.activity.screen.MainScreen
import ru.mos.app.presentation.view.impl.activity.testData.UserData
/*


class LoginScreenTest : BaseTest() {

    val user = UserData("snils")
    val authByEmail = UserData("email")


    @Test
    fun testAuthPhone() {
        before {
            openAuthScreen()
        }.after {}.run {

            step("Ввести в поле 'Телефон, почта или СНИЛС' валидный номер телефона") {
                onScreen<LoginScreen> {
                    loginField {
                        isDisplayed()
                        typeText(user.phone)
                    }
                }
            }

            step("Ввести в поле 'Пароль' валидный пароль") {
                onScreen<LoginScreen> {
                    passField {
                        isDisplayed()
                        replaceText(user.pass)
                        act {
                            ViewActions.closeSoftKeyboard()
                        }

                    }
                }
            }

            step("Нажать кнопку 'Войти'") {
                onScreen<LoginScreen> {
                    entryButton {
                        isDisplayed()
                        click()
                    }
                    waitAuthState(true)
                }
            }

            step("Деавторизоваться") {
                onScreen<MainScreen> {
                    logout()
                    waitAuthState(false)
                }
            }
        }
    }

    @Test
    fun testAuthSnils() {
        before {
            openAuthScreen()
        }.after {
        }.run {

            step("Ввести в поле 'Телефон, почта или СНИЛС' валидный снилс") {
                onScreen<LoginScreen> {
                    loginField {
                        isDisplayed()
                        typeText(user.snils)
                    }
                }
            }

            step("Ввести в поле 'Пароль' валидный пароль") {
                onScreen<LoginScreen> {
                    passField {
                        isDisplayed()
                        replaceText(user.pass)
                        act {
                            ViewActions.closeSoftKeyboard()
                        }

                    }
                }
            }

            step("Нажать кнопку 'Войти'") {
                onScreen<LoginScreen> {
                    entryButton {
                        isDisplayed()
                        click()
                    }
                    waitAuthState(true)
                }
            }

            step("Деавторизоваться") {
                onScreen<MainScreen> {
                    logout()
                    waitAuthState(false)
                }
            }
        }
    }

    @Test
    fun testAuthEmail() {
        before {
            openAuthScreen()
        }.after {
        }.run {

            step("Ввести в поле 'Телефон, почта или СНИЛС' валидный email") {
                onScreen<LoginScreen> {
                    loginField {
                        isDisplayed()
                        typeText(authByEmail.email)
                    }
                }
            }

            step("Ввести в поле 'Пароль' валидный пароль") {
                onScreen<LoginScreen> {
                    passField {
                        isDisplayed()
                        replaceText(authByEmail.pass)
                        act {
                            ViewActions.closeSoftKeyboard()
                        }

                    }
                }
            }

            step("Нажать кнопку 'Войти'") {
                onScreen<LoginScreen> {
                    entryButton {
                        isDisplayed()
                        click()
                    }
                    waitAuthState(true)
                }
            }

            step("Деавторизоваться") {
                onScreen<MainScreen> {
                    logout()
                    waitAuthState(false)
                }
            }
        }
    }

    @Test
    fun testInvalidLogin() {
        before {
            openAuthScreen()
        }.after {}.run{

            step("Ввести в поле 'Телефон, почта или СНИЛС' невалидный логин") {
                onScreen<LoginScreen> {
                    loginField {
                        isDisplayed()
                        typeText("nevalidno")
                    }
                }
            }

            step("Ввести в поле 'Пароль' валидный пароль") {
                onScreen<LoginScreen> {
                    passField {
                        isDisplayed()
                        replaceText(user.pass)
                        act {
                            ViewActions.closeSoftKeyboard()
                        }

                    }
                }
            }

            step("Нажать кнопку 'Войти'") {
                onScreen<LoginScreen> {
                    entryButton {
                        isDisplayed()
                        click()
                    }
                    invalidLoginAlert {
                        flakySafely(SHORT_DELAY) { isDisplayed() }
                    }
                }
            }
        }
    }

    @Test
    fun testInvalidPass() {
        before {
            openAuthScreen()
        }.after {}.run{

            step("Ввести в поле 'Телефон, почта или СНИЛС' валидный логин") {
                onScreen<LoginScreen> {
                    loginField {
                        isDisplayed()
                        typeText(user.phone)
                    }
                }
            }

            step("Ввести в поле 'Пароль' невалидный пароль") {
                onScreen<LoginScreen> {
                    passField {
                        isDisplayed()
                        replaceText("nevalidno")
                        act {
                            ViewActions.closeSoftKeyboard()
                        }

                    }
                }
            }

            step("Нажать кнопку 'Войти'") {
                onScreen<LoginScreen> {
                    entryButton {
                        isDisplayed()
                        click()
                    }
                    invalidPassAlert {
                        flakySafely(SHORT_DELAY) { isDisplayed() }
                    }
                }
            }
        }
    }

    @Test
    fun testEmptyLogin() {
        before {
            openAuthScreen()
        }.after {}.run{

            step("Нажать кнопку 'Войти'") {
                onScreen<LoginScreen> {
                    entryButton {
                        isDisplayed()
                        click()
                    }
                    emptyFieldMessage {
                        flakySafely(SHORT_DELAY) { isDisplayed() }
                    }
                }
            }
        }
    }

    @Test
    fun testEmptyPass() {
        before {
            openAuthScreen()
        }.after {}.run {

            step("Ввести в поле 'Телефон, почта или СНИЛС' валидный логин") {
                onScreen<LoginScreen> {
                    loginField {
                        isDisplayed()
                        typeText(user.phone)
                    }
                }
            }

            step("Нажать кнопку 'Войти'") {
                onScreen<LoginScreen> {
                    entryButton {
                        isDisplayed()
                        click()
                    }
                    emptyFieldMessage {
                        flakySafely(SHORT_DELAY) { isDisplayed() }
                    }
                }
            }
        }
    }

    @Test
    fun testForgetPassValidPass() {
        before {
            openAuthScreen()
        }.after {}.run {

            step("Нажать на 'Забыли пароль'") {
                onScreen<LoginScreen> {
                    forgotPassButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("В поле ввода 'Номер телефона' ввести валидный номер") {
                onScreen<ForgotPassScreen> {
                    numberField {
                        isDisplayed()
                        typeText(user.phone)
                    }
                }
            }

            step("Нажать 'Продолжить'") {
                onScreen<ForgotPassScreen> {
                    applyPhoneButton {
                        isDisplayed()
                        act {
                            ViewActions.closeSoftKeyboard()
                        }
                        click()
                    }
                }
            }


            step("В поле ввода 'Пароль' ввести валидный пароль") {
                onScreen<ForgotPassScreen> {
                    passField {
                        isDisplayed()
                        typeText(user.pass)
                    }
                }
            }

            step("Нажать 'Продолжить'") {
                onScreen<ForgotPassScreen> {
                    applyNewPassButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Проверить появление экрана 'Подтверждение'") {
                onScreen<ForgotPassScreen> {
                    confirmScreenTitle {
                        flakySafely(SHORT_DELAY) { isDisplayed() }
                    }
                }
            }
        }
    }

    @Test
    fun testForgetPassWrongPhone() {
        before {
            openAuthScreen()
        }.after {}.run {

            step("Нажать на 'Забыли пароль'") {
                onScreen<LoginScreen> {
                    forgotPassButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("В поле ввода 'Номер телефона' ввести невалидный номер") {
                onScreen<ForgotPassScreen> {
                    numberField {
                        isDisplayed()
                        typeText("5555555555")
                    }
                }
            }

            step("Нажать 'Продолжить'") {
                onScreen<ForgotPassScreen> {
                    applyPhoneButton {
                        isDisplayed()
                        act {
                            ViewActions.closeSoftKeyboard()
                        }
                        click()
                    }
                }
            }

            step("В поле ввода 'Пароль' ввести валидный пароль") {
                onScreen<ForgotPassScreen> {
                    passField {
                        isDisplayed()
                        typeText(user.pass)
                    }
                }
            }

            step("Нажать 'Продолжить'") {
                onScreen<ForgotPassScreen> {
                    applyNewPassButton {
                        isDisplayed()
                        act {
                            ViewActions.closeSoftKeyboard()
                        }
                        click()
                    }
                }
            }

            step("Проверить появление алёрта") {
                onScreen<ForgotPassScreen> {
                    notRegisteredAlert {
                        flakySafely(SHORT_DELAY) { isDisplayed() }
                    }
                }
            }
        }
    }

    @Test
    fun testForgetPassInvalidPhone() {
        before {
            openAuthScreen()
        }.after {}.run {

            step("Нажать на 'Забыли пароль'") {
                onScreen<LoginScreen> {
                    forgotPassButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("В поле ввода 'Номер телефона' ввести невалидный номер") {
                onScreen<ForgotPassScreen> {
                    numberField {
                        isDisplayed()
                        typeText("55555")
                    }
                }
            }

            step("Нажать 'Продолжить'") {
                onScreen<ForgotPassScreen> {
                    applyPhoneButton {
                        isDisplayed()
                        act {
                            ViewActions.closeSoftKeyboard()
                        }
                        click()
                    }
                }
            }

            step("Проверить наличие алёрта 'Неправильный номер телефона'") {
                onScreen<ForgotPassScreen> {
                    invalidPhoneText {
                        isDisplayed()
                    }
                }
            }
        }
    }

    @Test
    fun testForgetPassInvalidPass() {
        before {
            openAuthScreen()
        }.after {}.run {

            step("Нажать на 'Забыли пароль'") {
                onScreen<LoginScreen> {
                    forgotPassButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("В поле ввода 'Номер телефона' ввести валидный номер") {
                onScreen<ForgotPassScreen> {
                    numberField {
                        isDisplayed()
                        typeText(user.phone)
                    }
                }
            }

            step("Нажать 'Продолжить'") {
                onScreen<ForgotPassScreen> {
                    applyPhoneButton {
                        isDisplayed()
                        act {
                            ViewActions.closeSoftKeyboard()
                        }
                        click()
                    }
                }
            }

            step("В поле ввода 'Пароль' ввести невалидный пароль") {
                onScreen<ForgotPassScreen> {
                    passField {
                        isDisplayed()
                        typeText("neva")
                    }
                }
            }

            step("Нажать 'Продолжить'") {
                onScreen<ForgotPassScreen> {
                    applyNewPassButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Проверить появление алёрта") {
                onScreen<ForgotPassScreen> {
                    tooShortAlert {
                        flakySafely(SHORT_DELAY) { isDisplayed() }
                    }
                }
            }
        }
    }

    @Test
    fun testForgetPassEmptyPhone() {
        before {
            openAuthScreen()
        }.after {}.run {

            step("Нажать на 'Забыли пароль'") {
                onScreen<LoginScreen> {
                    forgotPassButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Нажать 'Продолжить'") {
                onScreen<ForgotPassScreen> {
                    applyPhoneButton {
                        isDisplayed()
                        act {
                            ViewActions.closeSoftKeyboard()
                        }
                        click()
                    }
                }
            }

            step("Проверить появление алёрта") {
                onScreen<LoginScreen> {
                    emptyFieldMessage {
                        flakySafely(SHORT_DELAY) { isDisplayed() }
                    }
                }
            }
        }
    }

    @Test
    fun testForgetPassEmptyPass() {
        before {
            openAuthScreen()
        }.after {}.run {

            step("Нажать на 'Забыли пароль'") {
                onScreen<LoginScreen> {
                    forgotPassButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("В поле ввода 'Номер телефона' ввести валидный номер") {
                onScreen<ForgotPassScreen> {
                    numberField {
                        isDisplayed()
                        typeText(user.phone)
                    }
                }
            }

            step("Нажать 'Продолжить'") {
                onScreen<ForgotPassScreen> {
                    applyPhoneButton {
                        isDisplayed()
                        act {
                            ViewActions.closeSoftKeyboard()
                        }
                        click()
                    }
                }
            }

            step("Нажать 'Продолжить'") {
                onScreen<ForgotPassScreen> {
                    applyNewPassButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Проверить появление алёрта") {
                onScreen<LoginScreen> {
                    emptyFieldMessage {
                        flakySafely(SHORT_DELAY) { isDisplayed() }
                    }
                }
            }
        }
    }

}

 */