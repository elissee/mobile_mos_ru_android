package ru.mos.app.presentation.view.impl.activity.screen

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import ru.mos.app.R

class  RateScreen : Screen<RateScreen>() {
    val dislikeButton = KButton {withText(R.string.dislike)}
    val likeButton = KButton {withText(R.string.like)}
    val goToMarketPopUp = KTextView {withText(R.string.go_to_play_dialog)}

}