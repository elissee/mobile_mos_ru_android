package ru.mos.app.presentation.view.impl.activity.screen

import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.edit.KTextInputLayout
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import io.qameta.allure.model.WithLinks
import ru.mos.app.R

class LoginScreen : Screen<LoginScreen>() {

    val title = KTextView {withText(R.string.entrance)}
    val loginField = KEditText {withId(R.id.user)}
    val passField = KEditText {withId(R.id.pass)}
    val forgotPassButton = KTextView {withText(R.string.reset_password)}
    val entryButton = KButton {withId(R.id.login)}


    val invalidLoginAlert = KTextView {withText("Введен некорректный логин или пароль. " +
            "Телефон может быть введен в любом формате, например, +79991234567. " +
            "Электронная почта должна содержать символ @.")}
    val invalidPassAlert = KTextView {withText("Неправильный логин или пароль")}
    val emptyFieldMessage = KTextView {withText("Поле не может быть пустым")}
}