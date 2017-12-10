package com.kotlin.forecast.kotlin_forcast.di

import com.kotlin.forecast.kotlin_forcast.App
import com.kotlin.forecast.kotlin_forcast.view.CityFragment
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton
import kotlin.reflect.KClass

/**
 * Create on 2017/12/9 下午4:01
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.9
 */
@Component(
        modules = arrayOf(
                NetworkModule::class,
                AndroidInjectionModule::class,
                AndroidSupportInjectionModule::class)

)
@Singleton
interface AppComponent {

    fun inject(cityFragment: CityFragment)
//    @Component.Builder
//    abstract class Builder : AndroidInjector.Builder<App>() {
//        abstract override fun build(): AppComponent
//    }

}