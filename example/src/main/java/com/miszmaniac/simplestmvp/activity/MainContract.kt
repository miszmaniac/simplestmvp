package com.miszmaniac.simplestmvp.activity

import com.miszmaniac.simplestmvp.extensions.DisposableRegistrants
import com.miszmaniac.simplestmvp.ui.MvpPresenter
import com.miszmaniac.simplestmvp.ui.MvpView

interface MainContract {

    interface View : MvpView<Presenter>

    interface Presenter : MvpPresenter<View>, DisposableRegistrants
}