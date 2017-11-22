package com.kotlin.forecast.kotlin_forcast.model.service

import com.kotlin.forecast.kotlin_forcast.model.NetInterface
import com.kotlin.forecast.kotlin_forcast.model.bean.ForecastBean
import io.reactivex.Flowable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Create on 2017/11/5 下午10:33
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.9
 */
interface CommonService{

    @GET(NetInterface.forecast)
    fun getForecast(@QueryMap args: Map<String, String>): Flowable<ForecastBean>

}