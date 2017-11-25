package com.kotlin.forecast.kotlin_forcast

import android.util.ArrayMap

/**
 * Create on 2017/11/25 下午2:21
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.9
 */
object WeatherMap {

    lateinit var weatherMap: Map<String, String>

    init {
        weatherMap = mapOf<String, String>(
                "100" to "https://cdn.heweather.com/cond_icon/100.png",
                "101" to "https://cdn.heweather.com/cond_icon/101.png",
                "102" to "https://cdn.heweather.com/cond_icon/102.png",
                "103" to "https://cdn.heweather.com/cond_icon/103.png",
                "104" to "https://cdn.heweather.com/cond_icon/104.png",
                "200" to "https://cdn.heweather.com/cond_icon/200.png",
                "201" to "https://cdn.heweather.com/cond_icon/201.png",
                "202" to "https://cdn.heweather.com/cond_icon/202.png",
                "203" to "https://cdn.heweather.com/cond_icon/203.png",
                "204" to "https://cdn.heweather.com/cond_icon/204.png",
                "205" to "https://cdn.heweather.com/cond_icon/205.png",
                "206" to "https://cdn.heweather.com/cond_icon/206.png",
                "207" to "https://cdn.heweather.com/cond_icon/207.png",
                "208" to "https://cdn.heweather.com/cond_icon/208.png",
                "209" to "https://cdn.heweather.com/cond_icon/209.png",
                "210" to "https://cdn.heweather.com/cond_icon/210.png",
                "211" to "https://cdn.heweather.com/cond_icon/211.png",
                "212" to "https://cdn.heweather.com/cond_icon/212.png",
                "213" to "https://cdn.heweather.com/cond_icon/213.png",
                "300" to "https://cdn.heweather.com/cond_icon/300.png",
                "301" to "https://cdn.heweather.com/cond_icon/301.png",
                "302" to "https://cdn.heweather.com/cond_icon/302.png",
                "303" to "https://cdn.heweather.com/cond_icon/303.png",
                "304" to "https://cdn.heweather.com/cond_icon/304.png",
                "305" to "https://cdn.heweather.com/cond_icon/305.png",
                "306" to "https://cdn.heweather.com/cond_icon/306.png",
                "307" to "https://cdn.heweather.com/cond_icon/307.png",
                "308" to "https://cdn.heweather.com/cond_icon/308.png",
                "309" to "https://cdn.heweather.com/cond_icon/309.png",
                "310" to "https://cdn.heweather.com/cond_icon/310.png",
                "311" to "https://cdn.heweather.com/cond_icon/311.png",
                "312" to "https://cdn.heweather.com/cond_icon/312.png",
                "313" to "https://cdn.heweather.com/cond_icon/313.png",
                "400" to "https://cdn.heweather.com/cond_icon/400.png",
                "401" to "https://cdn.heweather.com/cond_icon/401.png",
                "402" to "https://cdn.heweather.com/cond_icon/402.png",
                "403" to "https://cdn.heweather.com/cond_icon/403.png",
                "404" to "https://cdn.heweather.com/cond_icon/404.png",
                "405" to "https://cdn.heweather.com/cond_icon/405.png",
                "406" to "https://cdn.heweather.com/cond_icon/406.png",
                "407" to "https://cdn.heweather.com/cond_icon/407.png",
                "500" to "https://cdn.heweather.com/cond_icon/500.png",
                "501" to "https://cdn.heweather.com/cond_icon/501.png",
                "502" to "https://cdn.heweather.com/cond_icon/502.png",
                "503" to "https://cdn.heweather.com/cond_icon/503.png",
                "504" to "https://cdn.heweather.com/cond_icon/504.png",
                "505" to "https://cdn.heweather.com/cond_icon/505.png",
                "506" to "https://cdn.heweather.com/cond_icon/506.png",
                "507" to "https://cdn.heweather.com/cond_icon/507.png",
                "508" to "https://cdn.heweather.com/cond_icon/508.png",
                "900" to "https://cdn.heweather.com/cond_icon/900.png",
                "901" to "https://cdn.heweather.com/cond_icon/901.png"
        )
    }

    /**
     * 根据天气code获取对应的icon URL
     */
    fun getIconUrlByCode(code: String): String? {
        return weatherMap.get(code)
    }

}