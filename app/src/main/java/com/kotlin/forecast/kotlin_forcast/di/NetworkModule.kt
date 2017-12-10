package com.kotlin.forecast.kotlin_forcast.di

import com.kotlin.forecast.kotlin_forcast.model.Domain
import com.kotlin.forecast.kotlin_forcast.model.LogInterceptor
import com.kotlin.forecast.kotlin_forcast.model.RequestBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Create on 2017/12/9 下午3:54
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.9
 */
@Module
class NetworkModule{

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Domain.forecastDomain)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideOkHttp(interceptor: Interceptor): OkHttpClient {
        return OkHttpClient().newBuilder()
                .retryOnConnectionFailure(true)
                .readTimeout(25, TimeUnit.SECONDS)
                .connectTimeout(25, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()
    }

    @Provides
    @Singleton
    fun provideLogInterceptor(logInterceptor: LogInterceptor): Interceptor {
        return logInterceptor;
    }

}