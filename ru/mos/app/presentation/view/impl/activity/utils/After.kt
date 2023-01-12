package ru.mos.app.presentation.view.impl.activity.utils

import android.util.Log
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource

class After(var after: () -> Boolean) : IdlingResource {

    private var id = System.currentTimeMillis()
    private lateinit var resourceCallback: IdlingResource.ResourceCallback
    override fun getName(): String {
        return id.toString()
    }

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback?) {
        resourceCallback = callback!!
    }

    override fun isIdleNow(): Boolean {
        val idle = after()
        Log.i("After", idle.toString())
        if(idle) resourceCallback.onTransitionToIdle()
        return idle
    }

    fun execute(callable: () -> Any?) {
        try {
            IdlingRegistry.getInstance().register(this)
            callable()
        } finally {
            IdlingRegistry.getInstance().unregister(this)
        }
    }

}
