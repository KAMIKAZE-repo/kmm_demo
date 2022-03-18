package com.jetbrains.kmm.androidApp

import android.app.Application
import com.jetbrains.kmm.shared.di.InjectorCommon
import com.jetbrains.kmm.shared.utils.ContextArgs

class Application: Application(){
    override fun onCreate() {
        super.onCreate()
        InjectorCommon.provideContextArgs(ContextArgs(this))
    }
}