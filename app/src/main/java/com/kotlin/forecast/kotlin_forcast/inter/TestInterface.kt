package com.kotlin.forecast.kotlin_forcast.inter

/**
 * Create on 2017/9/13 下午8:28
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.6
 */
interface TestInterface{

    val prop: Int

    fun testProp(){
        print(prop)
    }

    fun testMethod()

    fun wang()
    fun chen(){
        println("chen in TestInterface")
    }
}