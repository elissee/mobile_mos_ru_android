package ru.mos.app.presentation.view.impl.activity.screen

import com.agoda.kakao.screen.Screen
import com.kaspersky.kaspresso.flakysafety.FlakySafetyProvider
import junit.framework.AssertionFailedError
import ru.mos.app.app.environment.MosruApp
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.BaseTest.Static.allowedExceptions

// todo: запилить наследование всех скринов от BaseScreen
open class  BaseScreen: Screen<BaseScreen>() {

    val LONG_DELAY: Long = 5000
    val SHORT_DELAY: Long = 1500

    val isAuthorized: Boolean
        get() = MosruApp.get().login != null


    /**
     * Ожидание выполнения условия
     */
    fun FlakySafetyProvider.waitUntil(action: () -> Unit) =
            waitShown(AssertionFailedError::class.java, AssertionError::class.java, action = action)

    /**
     * Ожидание элемента
     */
    fun FlakySafetyProvider.waitShown(vararg allowed: Class<out Throwable>, action: () -> Unit) =
            flakySafely(
                    BaseTest.LONG_DELAY,
                    BaseTest.RETRY_INTERVAL,
                    allowedExceptions = allowedExceptions.apply { addAll(allowed) },
                    action = action
            )
}
