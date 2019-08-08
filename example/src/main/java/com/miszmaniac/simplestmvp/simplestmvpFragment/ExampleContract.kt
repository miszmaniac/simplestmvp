package com.miszmaniac.simplestmvp.simplestmvpFragment

import com.miszmaniac.simplestmvp.extensions.DisposableRegistrants
import com.miszmaniac.simplestmvp.ui.MvpPresenter
import com.miszmaniac.simplestmvp.ui.MvpView

interface ExampleContract {
    interface View : MvpView<Presenter>

    interface Presenter : MvpPresenter<View>, DisposableRegistrants
}