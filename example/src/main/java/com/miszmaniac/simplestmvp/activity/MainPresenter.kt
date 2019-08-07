package com.miszmaniac.simplestmvp.activity

import android.os.Bundle
import com.miszmaniac.simplestmvp.ui.SimplestMVPPresenter

class MainPresenter() : SimplestMVPPresenter<MainContract.View>(), MainContract.Presenter {

    override fun bind(extras: Bundle, savedInstanceState: Bundle?) {
    }

}