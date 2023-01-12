package ru.mos.app.presentation.view.impl.activity

import android.app.Activity
import android.os.SystemClock
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatEditText
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.*
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.web.assertion.WebViewAssertions
import androidx.test.espresso.web.model.Atoms
import androidx.test.espresso.web.sugar.Web.onWebView
import androidx.test.espresso.web.webdriver.DriverAtoms
import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.rule.ActivityTestRule
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.textfield.TextInputLayout
import com.kaspersky.kaspresso.flakysafety.FlakySafetyProvider
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import junit.framework.AssertionFailedError
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.internal.matchers.TypeSafeMatcher
import org.junit.runner.RunWith
import ru.mos.app.R
import ru.mos.app.app.environment.MosruApp
import ru.mos.app.presentation.view.impl.activity.rule.ClearDatabaseRule
import ru.mos.app.presentation.view.impl.activity.rule.ClearFilesRule
import ru.mos.app.presentation.view.impl.activity.rule.ClearPreferencesRule
import ru.mos.app.presentation.view.impl.activity.testData.UserData
import ru.mos.app.presentation.view.impl.activity.utils.After
import ru.mos.app.presentation.view.impl.activity.utils.ViewShownIdlingResource
import java.io.File
import java.util.*

    @RunWith(AndroidJUnit4::class)
    open class BaseTest : TestCase() {

    var onboardingScreenState = false

    @get:Rule
    var mActivityRule: ActivityTestRule<WebViewActivity> = object : ActivityTestRule<WebViewActivity>(WebViewActivity::class.java, false, false) {
        override fun afterActivityLaunched() {
            onWebView(withId(R.id.web_view)).forceJavascriptEnabled()
        }
    }

    // Clear all app's SharedPreferences
    @get:Rule
    var clearPreferencesRule = ClearPreferencesRule()
    // Delete all tables from all the app's SQLite Databases
    @get:Rule
    var clearDatabaseRule = ClearDatabaseRule()
    //     Delete all files in getFilesDir() and getCacheDir()
    @get:Rule
    var clearFilesRule = ClearFilesRule()

    @get:Rule
    //var mExtMainActivity = ActivityTestRule(ru.mos.ext.ui.activity.MainActivity::class.java, true, false)
    var mExtMainActivity = ActivityTestRule(ru.mos.uivm.AppActivity::class.java, true, false)

    val isAuthorized: Boolean
        get() = MosruApp.get().login != null


    val currentActivity: Activity?
        get() {
            val activity = arrayOfNulls<Activity>(1)
            onView(isRoot()).check { view, noViewFoundException -> activity[0] = view.findViewById<View>(android.R.id.content).context as Activity }
            return activity[0]
        }

    @Before
    fun setup() {
        //onboardingScreenState = disableOnboardingActivity()
        mExtMainActivity.launchActivity(null)
    }

    /**
     * Открыть личнй кабинет/экран авторизации
     */
    fun openLoginScreen(state: Boolean) {
        if (!state) {
            SystemClock.sleep(LONG_DELAY)
            waitViewShown(allOf(withId(R.id.btn_action), isClickable()))
        }
        //SystemClock.sleep(LONG_DELAY)
        onView(withId(R.id.btn_action))
                .perform(click())
    }

    /**
     * Экрана авторизации больше нет, затрагивает тесты с логином
     */
    /*
    fun openAuthScreen() {
        val isOnboardingScreenDisable = disableOnboardingActivity()
        openLoginScreen(isOnboardingScreenDisable)
        waitViewShown(withText(R.string.entrance))
    }
     */


        /**
         * Подмена приветственного экрана следующим xml
         */
        //todo: не функционирует, обновить методы
/*
fun disableOnboardingActivity(): Boolean {
        val targetPref = "onboarding_key.xml"
        //val context = InstrumentationRegistry.getTargetContext().applicationContext
        val context = getInstrumentation().getTargetContext().applicationContext
        val prefsFolder = context.applicationInfo.dataDir + "/shared_prefs"
        val prefNames = Arrays.asList(*File(prefsFolder).list())
        if (prefNames.contains(targetPref)) {
            val pref = context.getSharedPreferences(targetPref.substring(0, targetPref.indexOf(".xml")), 0)
            pref.edit().putBoolean("onboarding_key", true).apply()
            return true
        } else {
            return false
        }
    }
 */




    fun auth(user: UserData) {
            onWebView(withId(R.id.web_view))
                    .withElement(DriverAtoms.findElement(Locator.ID, "login"))
                    .perform(DriverAtoms.webClick())
                    .check(WebViewAssertions.webMatches(Atoms.getCurrentUrl(), Matchers.containsString("Логин (телефон, email или СНИЛС)")))
    }

    fun openProfileScreen(user: UserData) {
        mExtMainActivity.launchActivity(null)
        openLoginScreen(onboardingScreenState)
        if (!isAuthorized) {
            auth(user)
            After { isAuthorized }
                    //.execute { onView(withId(R.id.settings)).perform(click()) }
                    //.execute { onView(withId(R.id.btn_action)).perform(click()) }
                    //.execute { onView(allOf(withId(R.id.btn_action), isDisplayed())).perform(click()) }
            //onView(withId(R.id.btn_action)).check(matches(isDisplayed())).perform(click())
                    .execute { onView(withContentDescription("Настройки")).perform(click()) }
        }
        shouldBeDisplayed(withText(user.name))
    }

    fun waitAuthState(state: Boolean) {
        After { isAuthorized == state }
                .execute { onView(withId(R.id.view_welcomeHeader_avatar)).perform() }
    }

    /**
     *
     */
    fun FlakySafetyProvider.waitUntil(action: () -> Unit) =
            waitShown(AssertionFailedError::class.java, AssertionError::class.java, action = action)

    /**
     * ожидание элемента
     */
    fun FlakySafetyProvider.waitShown(vararg allowed: Class<out Throwable>, action: () -> Unit) =
            flakySafely(
                    LONG_DELAY,
                    RETRY_INTERVAL,
                    allowedExceptions = allowedExceptions.apply { addAll(allowed) },
                    action = action
            )

    companion object Static {

        val LONG_DELAY: Long = 5000L
        val SHORT_DELAY: Long = 1500L
        val RETRY_INTERVAL: Long = 200L

        val allowedExceptions: MutableSet<Class<out Throwable>> =
                mutableSetOf(
                        PerformException::class.java,
                        NoMatchingViewException::class.java,
                        AssertionError::class.java,
                        IllegalStateException::class.java,
                        AssertionFailedError::class.java,
                        AssertionError::class.java
                )

        fun waitViewEnabled(matcher: Matcher<View>) {
            val idlingResource = ViewShownIdlingResource(matcher)
            try {
                IdlingRegistry.getInstance().register(idlingResource)
                onView(matcher).check(matches(isEnabled()))
            } finally {
                IdlingRegistry.getInstance().unregister(idlingResource)
            }
        }

        fun waitViewShown(matcher: Matcher<View>) {
            val idlingResource = ViewShownIdlingResource(matcher)
            try {
                IdlingRegistry.getInstance().register(idlingResource)
                onView(matcher).check(matches(isDisplayed()))
            } finally {
                IdlingRegistry.getInstance().unregister(idlingResource)
            }
        }

        /**
         * Метод проверяет наличие хинта в элементе. На вход принимает ожидаемую строку,
         * возращает true/false
         */
        fun hasInputHintText(expectedText: String): Matcher<View> {
            return object : TypeSafeMatcher<View>() {
                override fun matchesSafely(view: View): Boolean {
                    if (view !is AppCompatEditText) {
                        return false
                    }
                    val hint = (view.getParent().parent as TextInputLayout).hint ?: return false
                    return expectedText == hint
                }

                override fun describeTo(description: Description) {}
            }
        }

        /**
         * Метод для изменения состояния тулбара. False устанавливает свёрнутое состояние
         */
        fun setToolbarExpanded(expanded: Boolean?): ViewAction {
            return object : ViewAction {
                override fun getConstraints(): Matcher<View> {
                    return isAssignableFrom(AppBarLayout::class.java)
                }

                override fun getDescription(): String {
                    return "Collapse App Bar Layout"
                }

                override fun perform(uiController: UiController, view: View) {
                    val appBarLayout = view as AppBarLayout
                    appBarLayout.setExpanded(expanded!!)
                    uiController.loopMainThreadUntilIdle()
                }
            }
        }

        fun childAtPosition(
                parentMatcher: Matcher<View>, position: Int): Matcher<View> {

            return object : org.hamcrest.TypeSafeMatcher<View>() {
                override fun describeTo(description: Description) {
                    description.appendText("Child at position $position in parent ")
                    parentMatcher.describeTo(description)
                }

                public override fun matchesSafely(view: View): Boolean {
                    val parent = view.parent
                    return (parent is ViewGroup && parentMatcher.matches(parent)
                            && view == parent.getChildAt(position))
                }
            }
        }

        fun shouldBeDisplayed(matcher: Matcher<View>): Boolean {
            if (isElementDisplayed(matcher)) {
                return true
            } else {
                onView(matcher).check(matches(isDisplayed()))
                return false
            }

        }

        fun shouldBeDisplayed(matcher: Matcher<View>, tryCount: Int, timeout: Int): Boolean {
            if (isElementDisplayed(matcher, tryCount, timeout)) {
                return true
            } else {
                onView(matcher).check(matches(isDisplayed()))
                return false
            }

        }

        fun isElementDisplayed(matcher: Matcher<View>): Boolean {
            for (i in 0..4) {
                try {
                    onView(matcher).check(matches(isDisplayed()))
                    return true
                } catch (notExist: NoMatchingViewException) {
                    SystemClock.sleep(SHORT_DELAY)
                }

            }
            return false
        }

        fun isElementDisplayed(matcher: Matcher<View>, tryCount: Int, timeout: Int): Boolean {
            for (i in 0 until tryCount) {
                try {
                    onView(matcher).check(matches(isDisplayed()))
                    return true
                } catch (notExist: NoMatchingViewException) {
                    SystemClock.sleep((timeout / tryCount).toLong())
                }

            }
            return false
        }
    }
}
