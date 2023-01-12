package ru.mos.app.presentation.view.impl.activity.screen

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView

class  ChildrenSchoolScreen : Screen<ChildrenSchoolScreen>() {

    val title = KTextView {withText("Дети в школе")}
    val backButton = KButton {withContentDescription("Navigate up")}
}