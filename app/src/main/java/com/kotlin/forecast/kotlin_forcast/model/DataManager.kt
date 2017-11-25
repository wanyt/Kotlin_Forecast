package com.kotlin.forecast.kotlin_forcast.model

import android.support.v4.util.ArrayMap
import com.kotlin.forecast.kotlin_forcast.model.bean.ForecastBean
import com.kotlin.forecast.kotlin_forcast.model.bean.RealTimeBean
import com.kotlin.forecast.kotlin_forcast.model.service.CommonService
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
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

    private val network = RequestBuilder.retrofit.create(CommonService::class.java)

    //获取近期的天气预报
    fun getForecast(args: Map<String, String>): Flowable<ForecastBean> =
            network.getForecast(args)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread());

    //获取实时天气
    fun getRealTimeInfo(params: ArrayMap<String, String>): Flowable<RealTimeBean> =
            network.getRealTimeInfo(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());


}