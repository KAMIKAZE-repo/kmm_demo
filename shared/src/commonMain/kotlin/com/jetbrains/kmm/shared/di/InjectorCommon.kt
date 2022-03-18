package com.jetbrains.kmm.shared.di

import com.jetbrains.kmm.shared.utils.ContextArgs
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object InjectorCommon {

    var mContextArgs: ContextArgs? = null

    fun provideContextArgs(contextArgs: ContextArgs): ContextArgs? {
        mContextArgs = contextArgs
        return mContextArgs
    }


}