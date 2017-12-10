package com.kotlin.forecast.kotlin_forcast.contract

import com.kotlin.forecast.kotlin_forcast.base.BaseMVPContract
import com.kotlin.forecast.kotlin_forcast.base.BaseMVPPresenter
import com.kotlin.forecast.kotlin_forcast.model.bean.CityBean
import com.kotlin.forecast.kotlin_forcast.model.bean.ForecastBean
import com.kotlin.forecast.kotlin_forcast.model.bean.FutureInfo
import com.kotlin.forecast.kotlin_forcast.model.bean.RealTimeBean

/**
 * Create on 2017/11/24 下午8:20
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.9
 */
class CityContract {


    interface View : BaseMVPContract.View {
        fun getCityBean(): CityBean
        fun showForecastInfo(it: ForecastBean)
        fun showRealTimeInfo(it: RealTimeBean)
        fun showFutureWeatherInfo(list: ArrayList<FutureInfo>)
    }

    interface Presenter : BaseMVPPresenter<View> {
        fun getWeatherInfo(city: CityBean)
    }

}