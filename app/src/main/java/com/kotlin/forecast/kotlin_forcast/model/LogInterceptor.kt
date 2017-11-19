package com.kotlin.forecast.kotlin_forcast.model

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.internal.platform.Platform
import okhttp3.internal.platform.Platform.INFO
import java.lang.System.*

/**
 * Create on 2017/11/1 下午8:09
 * <p>
 * author wang
 * <p>
 * Description: 请求log拦截打印
 * <p>
 * Version: 1.0.9
 */
class LogInterceptor : Interceptor {

    private var logger: Logger

    interface Logger {

        fun log(msg: String)

        companion object {

            val DEFAULT: Logger = object : Logger {
                override fun log(msg: String) {
                    Platform.get().log(INFO, msg, null)
                }
            }
        }
    }

    override fun intercept(chain: Interceptor.Chain?): Response {

        //请求
        val request = chain?.request()
        val nanoTime = nanoTime()
        logger.log(String.format("Sending request %s on %s%n%s", request?.url(), chain?.connection(), request?.headers()));


        //响应
        val response = chain?.proceed(request!!)
        val t2 = System.nanoTime()
        logger.log(String.format("Received response for %s in %.1fms%n%s", response?.request()?.url(), (t2 - nanoTime) / 1e6, response?.headers()))

        return response!!
    }

    init {
        this.logger = Logger.DEFAULT
    }

}