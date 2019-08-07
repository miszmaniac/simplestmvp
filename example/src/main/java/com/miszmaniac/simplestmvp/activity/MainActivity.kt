package com.miszmaniac.simplestmvp.activity

import com.miszmaniac.simplestmvp.R
import com.miszmaniac.simplestmvp.ui.SimplestMVPActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : SimplestMVPActivity<MainContract.View, MainContract.Presenter>(), MainContract.View {
    override fun handleErrorAndShowToast(e: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleErrorAndShowAlert(e: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleErrorSilently(e: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val layoutId: Int get() = R.layout.activity_main
    override val presenter by inject<MainContract.Presenter> { parametersOf(activity) }

}
