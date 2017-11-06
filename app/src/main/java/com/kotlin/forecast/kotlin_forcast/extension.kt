package com.kotlin.forecast.kotlin_forcast

import android.app.Activity
import android.widget.Toast
import java.util.logging.Logger

/**
 * Create on 2017/9/14 上午9:17
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.6
 */

//val logger: Logger = Logger{
//    override fun log(msg: String){
//
//    }
//}



val <T> List<T>.lastIndex: Int
    get() = size - 1

fun <T> List<T>.getFirstElement(){
    if (this != null) {

    }
}

fun Activity.toastShort(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}