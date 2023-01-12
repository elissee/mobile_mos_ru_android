package ru.mos.app.presentation.view.impl.activity.screen

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.agoda.kakao.check.KCheckBox
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import ru.mos.app.R

class  SecurityScreen : Screen<SecurityScreen>() {

    //val securityOnEntryText = KTextView {withText(R.string.use_code)}
    val securityOnEntryText = KTextView {withId(R.id.tv_title)}
    val securitySwitchBlock = KButton {withId(R.id.view_profileItem_switch_container)}
    //val securitySwitch = KCheckBox {withId(R.id.view_profileItem_switch)}
    val securitySwitch = KCheckBox {withId(R.id.view_switch)}
    val securityInfo = KTextView {withText(R.string.profile_security_info)}
    //todo: найти новые id или strting
    //val entryCodeTitle = KTextView {withText(R.string.pincode_title_enter_new)}
    //val confirmCodeTitle = KTextView {withText(R.string.pincode_title_enter_confirm)}
    val entryCodeTitle = KTextView {withText(R.string.pincode_title_enter_code)}
    val confirmCodeTitle = KTextView {withText(R.string.pincode_title_enter_code_confirm)}
    val blockInterval = KTextView {withText(R.string.no_code_interval)}
    val changeCode = KTextView {withText(R.string.profile_security_change_code)}
    val useFingerprint = KTextView {withText(R.string.use_touch)}

    fun setCodeEntry(vararg codeNumbers: String) {
        for (i in codeNumbers.indices) {
            onView(withText(codeNumbers[i]))
                    .check(matches(isDisplayed()))
                    .perform(click())
        }
    }
}