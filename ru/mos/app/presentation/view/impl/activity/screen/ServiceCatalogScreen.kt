package ru.mos.app.presentation.view.impl.activity.screen

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.kaspersky.kaspresso.flakysafety.FlakySafetyProvider
import ru.mos.app.presentation.view.impl.activity.BaseTest.Static.allowedExceptions
import ru.mos.app.presentation.view.impl.activity.utils.NestedScrollViewExtension

class ServiceCatalogScreen : Screen<ServiceCatalogScreen>(){
    val allservices = KButton {withText("Все услуги mos.ru")}


    fun FlakySafetyProvider.clickToService(serviceName: String) {

       allservices {
           flakySafely(10000, 1000, allowedExceptions = allowedExceptions) {
               click() }

       }
    }
}