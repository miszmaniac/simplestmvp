package com.miszmaniac.simplestmvp.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<VIEW : MvpView<PRESENTER>, out PRESENTER : MvpPresenter<VIEW>>
    : AppCompatActivity(), MvpView<PRESENTER> {

    abstract val layoutId: Int
    override val activity: Activity
        get() = this

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        onViewBound()
        @Suppress("UNCHECKED_CAST")
        presenter.view = this as VIEW
        presenter.bind(intent.extras ?: Bundle.EMPTY, savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(outState)
    }

    @CallSuper
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        presenter.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    @CallSuper
    override fun onDestroy() {
        presenter.unbind()
        super.onDestroy()
    }

}