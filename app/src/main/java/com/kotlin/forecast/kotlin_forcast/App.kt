package com.kotlin.forecast.kotlin_forcast

import android.app.Application
import com.kotlin.forecast.kotlin_forcast.di.AppComponent
import com.kotlin.forecast.kotlin_forcast.di.DaggerAppComponent
import com.kotlin.forecast.kotlin_forcast.di.NetworkModule

/**
 * Create on 2017/12/9 下午4:03
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.9
 */
class App : Application() {

    val create: AppComponent by lazy {
        DaggerAppComponent.builder()
                .build()
    }

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}