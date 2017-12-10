package com.kotlin.forecast.kotlin_forcast

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast

/**
 * Create on 2017/9/14 上午9:17
 * <p>
 * author wang
 * <p>
 * Description: 所有的扩展方法
 * <p>
 * Version: 1.0.6
 */

val <T> List<T>.lastIndex: Int
    get() = size - 1

fun Activity.toastShort(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Activity.debugInfo(msg: String){
    val tag = "log info>>"
    Log.d(tag, msg);
}