package com.miszmaniac.simplestmvp.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle

interface MvpView<out T : MvpPresenter<*>> {

    val presenter: T
    val activity: Activity

    fun onViewBound() {

    }

    fun handleErrorAndShowToast(e: Throwable)

    fun handleErrorAndShowAlert(e: Throwable)

    fun handleErrorSilently(e: Throwable)

    fun startActivity(clazz: Class<*>, options: Bundle? = null, paramInjector: (Intent.() -> Unit)? = null) {
        activity.startActivity(Intent(activity, clazz).apply { paramInjector?.invoke(this) }, options)
    }

    fun startActivityAndFinish(clazz: Class<*>, options: Bundle? = null, paramInjector: (Intent.() -> Unit)? = null) {
        startActivity(clazz, options, paramInjector)
        activity.finish()
    }

    fun startActivityForResult(clazz: Class<*>, requestCode: Int, options: Bundle? = null, paramInjector: (Intent.() -> Unit)? = null) {
        activity.startActivityForResult(Intent(activity, clazz).apply { paramInjector?.invoke(this) }, requestCode, options)
    }

    fun startActivityIfStackEmpty(clazz: Class<*>, options: Bundle? = null, paramInjector: (Intent.() -> Unit)? = null) {
        if (activity.isTaskRoot) startActivity(clazz, options, paramInjector)
    }
}