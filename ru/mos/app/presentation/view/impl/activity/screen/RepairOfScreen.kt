package ru.mos.app.presentation.view.impl.activity.screen

import androidx.test.espresso.Espresso
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.tabs.KTabLayout
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import ru.mos.app.R
import java.util.regex.Pattern.matches

class RepairOfScreen : Screen<RepairOfScreen>() {
    val smart = KButton {withId(R.id.container_smartphone)}
    val tablet = KButton {withId(R.id.container_tablet)}
    val laptop = KButton {withId(R.id.container_laptop)}
    val mono = KButton {withId(R.id.container_mono)}
    val pc = KButton {withId(R.id.container_pc)}
    val printer = KButton{withId(R.id.container_printer)}
    val cont = KButton{withId(R.id.btn_continue)}
    val backButton = KButton {withContentDescription("Navigate up")}
    val linkOne = KTextView {withId(R.id.btn_ct_faq_how_to_deliver)}
    val linkTwo = KTextView {withId(R.id.btn_ct_faq_how_to_repair)}
    val linkThree = KTextView{withId(R.id.btn_ct_faq_how_to_pay)}
    val logo = KButton {withText("Чудо техники")}
    val device = KTextView {withId(R.id.txt_device)}
    val brand = KTextView {withId(R.id.txt_brand)}
    val modelField = KEditText {withId(R.id.txt_model)}
    val problemField = KEditText {withId(R.id.txt_problem)}
    val nameField = KEditText {withId(R.id.txt_name)}
    val phoneField = KEditText {withId(R.id.txt_phone)}
    val addressField = KEditText {withId(R.id.txt_address)}
    val linkConditions = KTextView {withId(R.id.lbl_rules)}
    val cancel = KButton {withText("Отмена") }
    val device1 = KButton {withText("Смартфон")}
    val brand1 = KButton {withText ("Acer")}
    val send = KButton {withId(R.id.btn_continue)}


}