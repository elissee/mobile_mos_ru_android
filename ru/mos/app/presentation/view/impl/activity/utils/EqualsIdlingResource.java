package ru.mos.app.presentation.view.impl.activity.utils;

import androidx.test.espresso.IdlingResource;

public class EqualsIdlingResource implements IdlingResource {

    private Object first;
    private Object second;
    private ResourceCallback resourceCallback;

    public EqualsIdlingResource(final Object first,final Object second) {
        this.first = first;
        this.second = second;

    }

    @Override
    public String getName() {
        return this.getClass().toString();
    }

    @Override
    public boolean isIdleNow() {
        boolean idle = first == second;

        if (idle && resourceCallback != null) {
            resourceCallback.onTransitionToIdle();
        }

        return idle;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        this.resourceCallback = callback;
    }
}
