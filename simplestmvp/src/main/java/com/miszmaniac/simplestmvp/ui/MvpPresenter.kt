package com.miszmaniac.simplestmvp.ui

import android.content.Intent
import android.os.Bundle

interface MvpPresenter<T> {

    var view: T

    fun onResume()

    fun onPageShow()

    fun bind(extras: Bundle, savedInstanceState: Bundle?) {

    }

    fun unbind() {

    }

    fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {

    }

    fun onSaveInstanceState(outState: Bundle) {

    }
}