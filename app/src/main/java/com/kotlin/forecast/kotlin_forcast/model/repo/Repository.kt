package com.kotlin.forecast.kotlin_forcast.model.repo

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.kotlin.forecast.kotlin_forcast.model.RequestBuilder
import com.kotlin.forecast.kotlin_forcast.model.bean.ForecastBean
import com.kotlin.forecast.kotlin_forcast.model.bean.RealTimeBean
import com.kotlin.forecast.kotlin_forcast.model.service.CommonService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Create on 2017/12/8 下午2:49
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.9
 */
class Repository {

    private val network = RequestBuilder.retrofit.create(CommonService::class.java)

    /**
     * 获取未来天气信息
     */
    fun getCityForecastInfo(args: Map<String, String>): MutableLiveData<ForecastBean> {
        val liveData = MutableLiveData<ForecastBean>()
        network.getForecast(args)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    liveData.value = it
                }, {

                })
        return liveData
    }

    /**
     * 获取实时天气
     */
    fun getCityRealTimeInfo(args: Map<String, String>): MutableLiveData<RealTimeBean> {
        val liveData = MutableLiveData<RealTimeBean>()
        network.getRealTimeInfo(args)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    liveData.value = it
                }, {

                })
        return liveData
    }

}