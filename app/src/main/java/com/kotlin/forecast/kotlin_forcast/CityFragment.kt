package com.kotlin.forecast.kotlin_forcast

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.forecast.kotlin_forcast.contract.CityContract
import com.kotlin.forecast.kotlin_forcast.model.bean.CityBean
import com.kotlin.forecast.kotlin_forcast.model.bean.ForecastBean
import com.kotlin.forecast.kotlin_forcast.model.bean.FutureInfo
import com.kotlin.forecast.kotlin_forcast.model.bean.RealTimeBean
import com.kotlin.forecast.kotlin_forcast.presenter.CityPresenter
import kotlinx.android.synthetic.main.fragment_city.*

/**
 * Create on 2017/10/24 下午11:20
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.9
 */
class CityFragment : Fragment(), CityContract.View{
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater?.inflate(R.layout.fragment_city, container, false)
        return inflate
    }

    /**
     * 延迟初始化城市数据
     */
    lateinit var city: CityBean

    /**
     * 延迟初始化presenter
     */
    lateinit var presenter: CityPresenter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getParams()

        presenter = CityPresenter(view = this)
        presenter.getWeatherInfo(city);
    }

    /**
     * 获取参数
     */
    private fun getParams() {
        city = arguments.getSerializable(Constants.params) as CityBean
        llRoot.background = resources.getDrawable(city.cityPic)
    }

    /**
     * 显示实时天气
     */
    override fun showRealTimeInfo(it: RealTimeBean) {
        val weatherInfo = it.HeWeather6.get(0)
        val nowInfo = weatherInfo.now
        val basicInfo = weatherInfo.basic

        tvName.text = basicInfo.location
        tvState.text = nowInfo.cond_txt
        tvTem.text = nowInfo.tmp
        tvTemState.text = ""

    }

    /**
     * 显示当天最高最低温度
     */
    override fun showForecastInfo(it: ForecastBean) {
        val weather = it.HeWeather6.get(0)
        val daily_forecast = weather.daily_forecast
        val curDay = daily_forecast.get(0);

        tvTemState.text = "${curDay.tmp_min}°/${curDay.tmp_max}°"
    }

    /**
     * 显示未来天气状况
     */
    override fun showFutureWeatherInfo(list: ArrayList<FutureInfo>) {
        recyclerView.layoutManager = GridLayoutManager(activity, 7)
        val futureInfoAdapter = FutureInfoAdapter(activity, list)
        recyclerView.adapter =futureInfoAdapter
    }

}


