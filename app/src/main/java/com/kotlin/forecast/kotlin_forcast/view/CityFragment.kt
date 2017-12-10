package com.kotlin.forecast.kotlin_forcast.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.forecast.kotlin_forcast.App
import com.kotlin.forecast.kotlin_forcast.Constants
import com.kotlin.forecast.kotlin_forcast.R
import com.kotlin.forecast.kotlin_forcast.model.bean.CityBean
import com.kotlin.forecast.kotlin_forcast.model.bean.FutureInfo
import kotlinx.android.synthetic.main.fragment_city.*
import okhttp3.Interceptor
import javax.inject.Inject

/**
 * Create on 2017/10/24 下午11:20
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.9
 */
class CityFragment : Fragment() {

    /**
     * 延迟初始化城市数据
     */
    lateinit var city: CityBean

    private lateinit var cityViewModel: CityViewModel

    @Inject
    lateinit var interceptor: Interceptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater?.inflate(R.layout.fragment_city, container, false)
        App.instance.create.inject(this)

        if (interceptor != null) {
            Log.d("aaaa>", "not null")
        } else {
            Log.d("aaaa>", "null")
        }

        return inflate
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        city = arguments.getSerializable(Constants.params) as CityBean
        llRoot.background = resources.getDrawable(city.cityPic)

        cityViewModel = ViewModelProviders.of(this).get(CityViewModel::class.java)
        cityViewModel.init(city)
        observeForecastInfo()
        observeRealTimeInfo()

        tvTemState.setOnClickListener { v -> v.id }
    }

    /**
     * 订阅实时天气信息
     */
    private fun observeRealTimeInfo() {
        cityViewModel.cityRealTimeInfo.observe(this, Observer {
            val weatherInfo = it!!.HeWeather6.get(0)
            val nowInfo = weatherInfo.now
            val basicInfo = weatherInfo.basic

            tvName.text = basicInfo.location
            tvState.text = nowInfo.cond_txt
            tvTem.text = nowInfo.tmp
            tvTemState.text = ""
        })
    }

    /**
     * 订阅未来天气信息
     */
    private fun observeForecastInfo() {
        cityViewModel.cityForecastInfo.observe(this, Observer {
            val weather = it!!.HeWeather6.get(0)
            val dailyForecast = weather.daily_forecast
            val curDay = dailyForecast.get(0)

            tvTemState.text = "${curDay.tmp_min}°/${curDay.tmp_max}°"
            showFutureWeatherInfo(weather.dailyModel)
        })

    }

    /**
     * 显示未来天气状况
     */
    private fun showFutureWeatherInfo(list: ArrayList<FutureInfo>) {
        recyclerView.layoutManager = GridLayoutManager(activity, 7)
        val futureInfoAdapter = FutureInfoAdapter(activity, list)
        recyclerView.adapter = futureInfoAdapter
    }

}


