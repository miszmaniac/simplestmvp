package com.miszmaniac.simplestmvp.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment

abstract class BaseFragment<VIEW : MvpView<PRESENTER>, out PRESENTER : MvpPresenter<VIEW>> :
    Fragment(),
    MvpView<PRESENTER> {

    private var invokeOnPageShowOnCreate = false
    abstract val layoutId: Int?
    override val activity: Activity
        get() = getActivity()!!

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if (layoutId != null) inflater.inflate(layoutId!!, container, false) else null
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNCHECKED_CAST")
        presenter.view = this as VIEW
        if (layoutId == null) invokeBind(arguments, savedInstanceState)
    }

    @CallSuper
    override fun onViewCreated(v: View, savedInstanceState: Bundle?) {
        super.onViewCreated(v, savedInstanceState)
        onViewBound()
        invokeBind(arguments, savedInstanceState)
    }

    private fun invokeBind(extras: Bundle?, savedInstanceState: Bundle?) {
        presenter.bind(extras ?: Bundle.EMPTY, savedInstanceState)
        if (invokeOnPageShowOnCreate) {
            presenter.onPageShow()
            invokeOnPageShowOnCreate = false
        }
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    @CallSuper
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            if (isAdded) {
                presenter.onPageShow()
            } else {
                invokeOnPageShowOnCreate = true
            }
        }
    }

    @CallSuper
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        presenter.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(outState)
    }

    fun removeFragment() {
        fragmentManager!!.beginTransaction()
            .remove(this)
            .commitNowAllowingStateLoss()
    }

    override fun startActivityForResult(
        clazz: Class<*>,
        requestCode: Int,
        options: Bundle?,
        paramInjector: (Intent.() -> Unit)?
    ) {
        startActivityForResult(
            Intent(activity, clazz).apply { paramInjector?.invoke(this) },
            requestCode,
            options
        )
    }

    @CallSuper
    override fun onDestroyView() {
        presenter.unbind()
        super.onDestroyView()
    }

}