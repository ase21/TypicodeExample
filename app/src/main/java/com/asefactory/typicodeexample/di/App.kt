package com.asefactory.typicodeexample.di

import android.app.Application
import com.asefactory.typicodeexample.di.app.AppComponent
import com.asefactory.typicodeexample.di.app.DaggerAppComponent

internal class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent
            .factory()
            .create(this)!!
    }

    companion object {
        var appComponent: AppComponent? = null
            private set
    }
}