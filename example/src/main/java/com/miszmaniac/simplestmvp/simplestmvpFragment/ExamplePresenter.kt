package com.miszmaniac.simplestmvp.simplestmvpFragment

import android.os.Bundle
import com.miszmaniac.simplestmvp.ui.BasePresenter

class ExamplePresenter(

) : BasePresenter<ExampleContract.View>(), ExampleContract.Presenter {

    override fun bind(extras: Bundle, savedInstanceState: Bundle?) {
    }

}