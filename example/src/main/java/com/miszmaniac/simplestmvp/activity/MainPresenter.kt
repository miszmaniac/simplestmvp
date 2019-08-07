package com.miszmaniac.simplestmvp.activity

import android.os.Bundle
import com.miszmaniac.simplestmvp.ui.BasePresenter

class MainPresenter() : BasePresenter<MainContract.View>(), MainContract.Presenter {

    override fun bind(extras: Bundle, savedInstanceState: Bundle?) {
    }

}