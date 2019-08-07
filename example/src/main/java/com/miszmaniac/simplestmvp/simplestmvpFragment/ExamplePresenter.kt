package com.miszmaniac.simplestmvp.simplestmvpFragment

import android.os.Bundle
import com.miszmaniac.simplestmvp.ui.SimplestMVPPresenter

class ExamplePresenter(

) : SimplestMVPPresenter<ExampleContract.View>(), ExampleContract.Presenter {

    override fun bind(extras: Bundle, savedInstanceState: Bundle?) {
    }

}