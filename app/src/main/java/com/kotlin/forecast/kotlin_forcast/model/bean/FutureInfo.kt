package com.kotlin.forecast.kotlin_forcast.model.bean

import java.text.Format
import java.text.SimpleDateFormat
import java.util.*

/**
 * Create on 2017/11/25 下午2:36
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.9
 */
data class FutureInfo(val code: String, val icUrl: String, val tmpRange: String) {

    var week  = ""

    fun setWeekInfo(date: String) {
        val list = arrayOf("SUN", "MON", "TUES", "WED", "THU", "FRI", "SAT")
        val sdf: Format = SimpleDateFormat("yyyy-MM-dd")

        val instance = Calendar.getInstance()
        instance.time = sdf.parseObject(date) as Date?

        var index: Int = instance.get(Calendar.DAY_OF_WEEK) - 1
        if (index < 0) {
            index = 0
        }

        week = list[index]
    }

}
