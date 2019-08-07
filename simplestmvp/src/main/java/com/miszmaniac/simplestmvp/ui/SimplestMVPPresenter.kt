package com.miszmaniac.simplestmvp.ui

import androidx.annotation.CallSuper
import com.getresponse.rooms2.extensions.DisposableRegistrants
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class SimplestMVPPresenter<VIEW : MvpView<*>> : MvpPresenter<VIEW>, DisposableRegistrants {

    override lateinit var view: VIEW

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onResume() {

    }

    override fun onPageShow() {

    }

    @CallSuper
    override fun unbind() {
        compositeDisposable.clear()
    }

    override fun registerDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}