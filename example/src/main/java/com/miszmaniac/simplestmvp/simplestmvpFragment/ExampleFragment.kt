package com.miszmaniac.simplestmvp.simplestmvpFragment

import com.miszmaniac.simplestmvp.R
import com.miszmaniac.simplestmvp.ui.BaseFragment
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class ExampleFragment : BaseFragment<ExampleContract.View, ExampleContract.Presenter>(),
    ExampleContract.View {
    override fun handleErrorAndShowToast(e: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleErrorAndShowAlert(e: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleErrorSilently(e: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val presenter by inject<ExampleContract.Presenter> { parametersOf(activity) }
    override val layoutId = R.layout.fragemnt_example

    override fun onViewBound() {
    }

}