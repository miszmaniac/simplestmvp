package com.miszmaniac.simplestmvp

import android.app.Activity
import android.app.Application
import com.miszmaniac.simplestmvp.activity.MainActivity
import com.miszmaniac.simplestmvp.activity.MainContract
import com.miszmaniac.simplestmvp.activity.MainPresenter
import com.miszmaniac.simplestmvp.simplestmvpFragment.ExampleContract
import com.miszmaniac.simplestmvp.simplestmvpFragment.ExamplePresenter
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.EmptyLogger
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

@Suppress("USELESS_CAST")
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            logger(logger = EmptyLogger())
            androidContext(this@App)
            modules(listOf(
                module {
                    factory { (activity: MainActivity) -> MainPresenter() as MainContract.Presenter }
                    factory { (activity: MainActivity) -> ExamplePresenter() as ExampleContract.Presenter }
                }
            ))
        }
    }

    private fun Activity.toParameters() = parametersOf(this)
}

