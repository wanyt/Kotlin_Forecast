package com.kotlin.forecast.kotlin_forcast.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Create on 2017/11/2 下午8:41
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.9
 */
class NetworkBuild{

    companion object {
        val baseUrl = "https://free-api.heweather.com/"

        val build: Retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(OkHttpBuilder.okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

}