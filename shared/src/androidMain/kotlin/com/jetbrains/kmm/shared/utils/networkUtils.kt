package com.jetbrains.kmm.shared.utils

import android.content.Context
import android.net.ConnectivityManager
import com.jetbrains.kmm.shared.di.InjectorCommon

actual class ContextArgs(
    var mContext: Context
)

actual fun isNetworkAvailable(): Boolean{
    val connectivityManager = InjectorCommon.mContextArgs?.mContext?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting

}