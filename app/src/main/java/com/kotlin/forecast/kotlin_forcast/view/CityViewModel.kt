package com.kotlin.forecast.kotlin_forcast.view

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.support.v4.util.ArrayMap
import com.kotlin.forecast.kotlin_forcast.WeatherMap
import com.kotlin.forecast.kotlin_forcast.model.bean.*
import com.kotlin.forecast.kotlin_forcast.model.repo.Repository

/**
 * Create on 2017/12/8 下午2:30
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.9
 */
class CityViewModel : ViewModel() {

    private lateinit var cityInfo: CityBean
    private val repository = Repository()
    lateinit var cityForecastInfo: LiveData<ForecastBean>
    lateinit var cityRealTimeInfo: LiveData<RealTimeBean>

    fun init(city: CityBean) {
        this.cityInfo = city

        val paramMap = ArrayMap<String, String>()
        paramMap.put("location", city.cityName)
        paramMap.put("key", "726096547ed942a3947b1e22c2c7b6ee")
        paramMap.put("lang", "en")
        getForecastInfo(paramMap)
        getRealTimeInfo(paramMap)
    }

    /**
     * 获取实时天气
     */
    private fun getRealTimeInfo(paramMap: ArrayMap<String, String>) {
        cityRealTimeInfo = repository.getCityRealTimeInfo(paramMap)
    }

    /**
     * 获取天气预报
     */
    private fun getForecastInfo(paramMap: ArrayMap<String, String>) {
        val rawCityForecastInfo = repository.getCityForecastInfo(paramMap)

        cityForecastInfo = Transformations.map(rawCityForecastInfo, {
            val daily_forecast = it.HeWeather6[0].daily_forecast
            it.HeWeather6[0].dailyModel = createForecastBean(daily_forecast)
            return@map it
        })
    }

    /**
     * 创建未来七天的天气数据模型
     */
    private fun createForecastBean(dailyInfo: List<DailyForecast>): ArrayList<FutureInfo> {
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

        return list
    }

}