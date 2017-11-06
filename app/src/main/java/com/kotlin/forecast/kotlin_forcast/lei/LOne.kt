package com.kotlin.forecast.kotlin_forcast.lei

import android.support.annotation.IntegerRes

/**
 * Create on 2017/10/22 下午11:11
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.9
 */
class LOne (name: String, age: Double = 1.0){

    open val theName = name

    init {
        print(theName)
    }

    constructor(name: String, age: Integer) : this(name){

    }


    fun step1(){

    }

}