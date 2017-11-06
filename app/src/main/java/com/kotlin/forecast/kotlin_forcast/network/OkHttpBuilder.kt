package com.kotlin.forecast.kotlin_forcast.network

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * Create on 2017/11/1 下午8:02
 * <p>
 * author wang
 * <p>
 * Description: 构建OkHttp的请求类
 * <p>
 * Version: 1.0.9
 */
class OkHttpBuilder {

    companion object {
        val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
                .retryOnConnectionFailure(true)
                .readTimeout(25, TimeUnit.SECONDS)
                .connectTimeout(25, TimeUnit.SECONDS)
                .addInterceptor(LogInterceptor())
                .build()
    }

}