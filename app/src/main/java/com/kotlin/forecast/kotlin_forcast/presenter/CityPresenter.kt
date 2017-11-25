package com.kotlin.forecast.kotlin_forcast.presenter

import android.support.v4.util.ArrayMap
import com.kotlin.forecast.kotlin_forcast.WeatherMap
import com.kotlin.forecast.kotlin_forcast.contract.CityContract
import com.kotlin.forecast.kotlin_forcast.model.DataManager
import com.kotlin.forecast.kotlin_forcast.model.bean.CityBean
import com.kotlin.forecast.kotlin_forcast.model.bean.DailyForecast
import com.kotlin.forecast.kotlin_forcast.model.bean.FutureInfo

/**
 * Create on 2017/11/24 下午8:22
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.9
 */
class CityPresenter(val view: CityContract.View) : CityContract.Presenter {

    /**
     * 获取天气数据
     */
    override fun getWeatherInfo(city: CityBean) {
        val paramMap = ArrayMap<String, String>()
        paramMap.put("location", city.cityName)
        paramMap.put("key", "726096547ed942a3947b1e22c2c7b6ee")
        paramMap.put("lang", "en")


        getForecastInfo(paramMap)
        getRealTimeInfo(paramMap)
    }

    /**
     * 获取实时天气数据
     */
    private fun getRealTimeInfo(params: ArrayMap<String, String>) {
        DataManager.getRealTimeInfo(params)
                .subscribe({ view.showRealTimeInfo(it) }, {})
    }

    /**
     * 获取未来天气数据
     */
    private fun getForecastInfo(params: ArrayMap<String, String>) {
        DataManager.getForecast(params)
                .subscribe({
                    view.showForecastInfo(it)
                    createForecastBean(it.HeWeather6.get(0).daily_forecast)
                }, {})
    }

    /**
     * 创建未来七天的天气数据模型
     */
    private fun createForecastBean(dailyInfo: List<DailyForecast>) {
        val list = ArrayList<FutureInfo>()
        dailyInfo.forEach {
            if (list.size < 7) {
                val code = it.cond_code_d
                val icUrl = WeatherMap.getIconUrlByCode(it.cond_code_d)
                val date = it.date
                val futureInfo = FutureInfo(code = code, icUrl = icUrl!!, tmpRange = "${it.tmp_min}°/${it.tmp_max}°")
                futureInfo.setWeekInfo(date)
                list.add(futureInfo)
            }
        }

        view.showFutureWeatherInfo(list)
    }


}