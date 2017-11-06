package com.kotlin.forecast.kotlin_forcast.network

import com.kotlin.forecast.kotlin_forcast.network.service.CommonService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit

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

    val network : CommonService = NetworkBuild.build.create(CommonService::class.java)

    fun getForecast(args: Map<String, String>) : Call<ResponseBody>{
        return network.getForecast(args)
    }


}