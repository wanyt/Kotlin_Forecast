package com.kotlin.forecast.kotlin_forcast.model.bean

/**
 * Create on 2017/11/25 上午11:55
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.9
 */

data class RealTimeBean(
		val HeWeather6: List<RealTimeWeather>
)

data class RealTimeWeather(
		val basic: RealTimeBasic,
		val status: String, //ok
		val now: Now
)

data class RealTimeBasic(
		val cid: String, //CN101020100
		val location: String, //上海
		val parent_city: String, //上海
		val admin_area: String, //上海
		val cnty: String, //中国
		val lat: String, //31.23170662
		val lon: String, //121.47264099
		val tz: String //+8.0
)

data class Now(
		val cloud: String, //0
		val cond_code: String, //101
		val cond_txt: String, //多云
		val fl: String, //16
		val hum: String, //33
		val pcpn: String, //0
		val pres: String, //1027
		val tmp: String, //14
		val vis: String, //7
		val wind_deg: String, //276
		val wind_dir: String, //西风
		val wind_sc: String, //微风
		val wind_spd: String //7
)

