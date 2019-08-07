package com.miszmaniac.simplestmvp.activity

import com.getresponse.rooms2.extensions.DisposableRegistrants
import com.miszmaniac.simplestmvp.ui.MvpPresenter
import com.miszmaniac.simplestmvp.ui.MvpView

interface MainContract {

    interface View : MvpView<Presenter>

    interface Presenter : MvpPresenter<View>, DisposableRegistrants
}