package com.kotlin.forecast.kotlin_forcast.model

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Create on 2017/11/19 下午10:10
 * <p>
 * author wang
 * <p>
 * Description: 创建网络请求对象
 * <p>
 * Version: 1.0.9
 */
object RequestBuilder {

    /*
     * 创建OkHttp客户端对象
     */
    val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .retryOnConnectionFailure(true)
            .readTimeout(25, TimeUnit.SECONDS)
            .connectTimeout(25, TimeUnit.SECONDS)
            .addInterceptor(LogInterceptor())
            .build()

    /**
     * 创建Retrofit对象
     */
    val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Domain.forecastDomain)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


}