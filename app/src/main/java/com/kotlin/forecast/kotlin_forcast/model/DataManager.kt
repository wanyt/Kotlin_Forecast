package com.kotlin.forecast.kotlin_forcast.model

import com.kotlin.forecast.kotlin_forcast.model.service.CommonService
import okhttp3.ResponseBody
import retrofit2.Call

/**
 * Create on 2017/11/2 下午8:51
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.9
 */
object DataManager {

    private val network = RequestBuilder.retrofit.create(CommonService::class.java)!!

    //获取近期的天气预报
    fun getForecast(args: Map<String, String>) : Call<ResponseBody> = network.getForecast(args)

}