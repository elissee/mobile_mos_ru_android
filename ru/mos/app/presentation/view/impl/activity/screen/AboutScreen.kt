package ru.mos.app.presentation.view.impl.activity.screen

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import ru.mos.app.R

class  AboutScreen : Screen<AboutScreen>() {
    val title = KTextView { withText(R.string.about_app)}
    val rateAppButton = KButton { withText(R.string.rate_app)}
    val recommendButton = KButton { withText(R.string.recommend_to_friend)}
    val agreementButton = KButton { withText(R.string.agreement)}
    val backButton = KButton {withContentDescription("Navigate up")}
}