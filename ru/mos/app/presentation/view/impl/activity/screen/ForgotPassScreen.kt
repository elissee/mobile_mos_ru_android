package ru.mos.app.presentation.view.impl.activity.screen

import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import ru.mos.app.R

class ForgotPassScreen : Screen<ForgotPassScreen>() {

    val title = KTextView {withText("Восстановление пароля")}
    val description = KTextView {withText("Мы отправим вам SMS с кодом подтверждения")}
    val numberField = KEditText {withId(R.id.user)}
    val applyPhoneButton = KButton {withId(R.id.reset)}
    val passField = KEditText {withId(R.id.pass)}
    val applyNewPassButton = KButton {withId(R.id.password)}
    val confirmScreenTitle = KTextView {withText(R.string.ovsa_string_confirm_title)}
    val notRegisteredAlert =  KTextView {withText("Номер: (75555555555) не зарегистрирован")}
    val tooShortAlert = KTextView {withText("Не менее 5 символов – латинские буквы или цифры")}
    val invalidPhoneText = KTextView {withId(R.id.textinput_error)}
}