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
class LOne(name: String, age: Double = 1.0) {

    open val theName = name

    init {
//        print(theName)
    }

    constructor(name: String, age: Integer) : this(name) {

    }


    fun step1(t1: String, t2: String) {

        val list = ArrayList<String>()
        list.add(t1)
        list.add(t2)

        list.filter { it.contains("0") }
                .map { it + "" }
                .forEach { println(::String) }

        val mapOf = mapOf(0 to "zero", 1 to "one", 2 to "two")

        mapOf.mapValues { it.value.toUpperCase() }
                .forEach { println("${it.key} 对应的值是 ${it.value}") }

    }

}