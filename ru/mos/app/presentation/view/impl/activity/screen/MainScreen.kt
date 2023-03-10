package ru.mos.app.presentation.view.impl.activity.screen

import android.os.SystemClock
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.web.assertion.WebViewAssertions
import androidx.test.espresso.web.assertion.WebViewAssertions.webMatches
import androidx.test.espresso.web.model.Atoms
import androidx.test.espresso.web.model.Atoms.getCurrentUrl
import androidx.test.espresso.web.sugar.Web.onWebView
import androidx.test.espresso.web.webdriver.DriverAtoms
import androidx.test.espresso.web.webdriver.DriverAtoms.*
import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.kaspersky.kaspresso.testcases.core.testcontext.BaseTestContext
import org.hamcrest.Matchers
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.containsString
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.mos.app.R
import ru.mos.app.presentation.view.impl.activity.BaseTest
import ru.mos.app.presentation.view.impl.activity.BaseTest.Static.LONG_DELAY
import ru.mos.app.presentation.view.impl.activity.BaseTest.Static.allowedExceptions
import ru.mos.app.presentation.view.impl.activity.BaseTest.Static.waitViewShown
import ru.mos.app.presentation.view.impl.activity.testData.UserData
import ru.mos.app.presentation.view.impl.activity.utils.After
import ru.mos.app.presentation.view.impl.activity.utils.NestedScrollViewExtension
import ru.mos.uivm.AppActivity
import java.io.File
import java.util.*

class  MainScreen : Screen<MainScreen>() {

    val title = KTextView { withText(R.string.app_name) }

    /**
     * ???????????? ??????????????
     */
    val home = KButton { withId(R.id.tab_home) }
    val news = KButton { withId(R.id.tab_news) }
    val payments = KButton { withId(R.id.tab_payments) }
    val services = KButton { withId(R.id.tab_services) }

    //???????????? ?????????? ?? ?????????????????? (??????????????????????????)

    //view_home_layout
    val login = KButton { withId(R.id.btn_action) }


    //view_home_layout
    //val settings = KButton { withId(R.id.settings)}
    //val settings = KButton { withId(R.id.btn_action)}
    val settings = KButton { withContentDescription("??????????????????") }

    //????????
    val chatChildrensSchool = KButton { withText(R.string.profile_kids_in_school) }
    val chatContactCenter = KButton { withText("??????????????-??????????") }
    val chatTransport = KButton { withText(R.string.profile_transport) }
    val chatMyHome = KButton { withText("?????? ??????") }
    val chatCityNews = KButton { withText("?????????????? ????????????") }
    val chatMedicine = KButton { withText("????????????????") }
    val chatMyDistrict = KButton { withText("?????? ??????????") }

    val serviceCatalog = KButton { withText("?????????????? ??????????") }
    val portalSearch = KButton { withText("?????????? ???? ??????????????") }
    val repairTechnics = KButton { withText("???????????? ??????????????") }
    val aboutApp = KButton { withText("?? ????????????????????") }
    val feedback = KButton { withText("???????????????? ??????????") }
    val ourApps = KButton { withText("???????? ????????????????????") }

    val baseScreen = BaseScreen()

    /**
     * ?????????????? ?????????? ?????????????????????? ?????? ???????????????????? ??????????????????????
     */
    fun closeWelcomeScreen() {
        waitViewShown(allOf(withId(R.id.btn_close), isClickable()))
        onView(withId(R.id.btn_close))
                .perform(click())
    }

    fun openLoginScreen(state: Boolean) {

        waitViewShown(allOf(withId(R.id.btn_close), isClickable()))
        onView(withId(R.id.btn_close))
                .perform(click())
        //SystemClock.sleep(LONG_DELAY)
        //SystemClock.sleep(LONG_DELAY)
        //onView(withId(R.id.btn_close))
                //.perform(click())
        if (!state) {
            waitViewShown(allOf(withId(R.id.btn_action), isClickable()))
        }
        //SystemClock.sleep(LONG_DELAY)
        onView(withId(R.id.btn_action))
                .perform(click())
    }

    /**
     * ?????????????????????? ?? ?????????? ?? try/catch
     */
    fun auth(user: UserData) {
        onWebView(withId(R.id.web_view))
        try {
            onWebView(withId(R.id.web_view))
                    .withElement(DriverAtoms.findElement(Locator.ID, "login"))
                    .perform(webClick())
                    .perform(webKeys(user.login))
                    .withElement(findElement(Locator.ID, "password"))
                    .perform(webClick())
                    .perform((webKeys(user.pass)))
                    .withElement(findElement(Locator.ID, "bind"))
                    .perform(webClick())
            /*
            } catch (ERROR: RuntimeException) {
            onWebView(withId(R.id.web_view))
                    .withElement(findElement(Locator.ID, "password"))
                    .perform(webClick())
                    .perform((webKeys(user.pass)))
                    .withElement(findElement(Locator.ID, "bind"))
                    .perform(webClick())
             */
        } catch (ERROR: java.lang.RuntimeException) {
            onWebView(withId(R.id.web_view))
                    //.withElement(findElement(Locator.LINK_TEXT, "notMeBtn"))
                    //.withElement(findElement(Locator.PARTIAL_LINK_TEXT, "?????? ???? ??"))
                    //.perform(webClick())
                    //.withElement(DriverAtoms.findElement(Locator.ID, "login"))
                    //.perform(webClick())
                    //.perform(webKeys(user.login))
                    .withElement(findElement(Locator.ID, "password"))
                    .perform(webClick())
                    .perform((webKeys(user.pass)))
                    .withElement(findElement(Locator.ID, "bind"))
                    .perform(webClick())
        }
}

    fun BaseTestContext.openProfileScreen(user: UserData, onboardingScreenState: Boolean) {
        if (!baseScreen.isAuthorized) {
            openLoginScreen(onboardingScreenState)
            auth(user)
        }
        /*
        settings {
            // todo: IllegalStateException ???? ??????????????????????????????, ?????????? ???????????????????????? ???????????? ??????
            flakySafely(LONG_DELAY, allowedExceptions = allowedExceptions) {
                isClickable()
                click()
            }
        }
         */
        SystemClock.sleep(LONG_DELAY)
        //waitViewShown(allOf(withContentDescription("??????????????????"), ViewMatchers.isClickable()))
        waitViewShown(allOf(withId(R.id.btn_action), withContentDescription("??????????????????"), isClickable()))
            //onView(withContentDescription("??????????????????"))
        onView(allOf(withId(R.id.btn_action), withContentDescription("??????????????????"))).perform(click())

        BaseTest.shouldBeDisplayed(withText(user.name))
    }

    fun BaseTestContext.logout() {
        settings {
            flakySafely(LONG_DELAY, allowedExceptions = allowedExceptions) { isClickable() }
            click()
        }
        val screen = ProfileScreen()
        screen.logOut.perform { act { NestedScrollViewExtension() } }
        screen.logOut.click()
        screen.modalLogoutButton.perform { click() }
        After { baseScreen.isAuthorized }
                .execute {}
    }
}