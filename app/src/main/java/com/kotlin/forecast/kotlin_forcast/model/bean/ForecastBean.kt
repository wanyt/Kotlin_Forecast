package com.kotlin.forecast.kotlin_forcast.model.bean

/**
 * Create on 2017/11/22 上午10:10
 * <p>
 * author wang
 * <p>
 * Description: 天气预报数据类
 * <p>
 * Version: 1.0.9
 */
data class ForecastBean(
		val HeWeather6: List<HeWeather6>
)

data class HeWeather6(
		val basic: Basic,
		val update: Update,
		val status: String, //ok
		val daily_forecast: List<DailyForecast>
)

data class Basic(
		val cid: String, //CN101010100
		val location: String, //北京
		val parent_city: String, //北京
		val admin_area: String, //北京
		val cnty: String, //中国
		val lat: String, //39.90498734
		val lon: String, //116.4052887
		val tz: String //+8.0
)

data class DailyForecast(
		val cond_code_d: String, //100
		val cond_code_n: String, //100
		val cond_txt_d: String, //晴
		val cond_txt_n: String, //晴
		val date: String, //2017-11-22
		val hum: String, //19
		val mr: String, //10:01
		val ms: String, //19:57
		val pcpn: String, //0.0
		val pop: String, //0
		val pres: String, //1026
		val sr: String, //07:06
		val ss: String, //16:55
		val tmp_max: String, //7
		val tmp_min: String, //-5
		val uv_index: String, //2
		val vis: String, //10
		val wind_deg: String, //338
		val wind_dir: String, //西北风
		val wind_sc: String, //微风
		val wind_spd: String //16
)

data class Update(
		val loc: String, //2017-11-22 09:50
		val utc: String //2017-11-22 01:50
)