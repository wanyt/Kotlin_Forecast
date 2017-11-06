package com.kotlin.forecast.kotlin_forcast.inter

import junit.framework.Test

/**
 * Create on 2017/9/13 下午8:29
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Version: 1.0.6
 */
internal class Impl : TestInterface, Impl2 {

    override fun testMethod() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    init {
        testProp()
    }

    override val prop: Int = 9

    override fun testProp() {
        super.testProp()
        print(prop)
    }


    override fun chen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun zhao() {

    }

    override fun wang() {
        println("Imple's wang" + prop)
//        super.chen();



        class abc {

            fun abcFun(){
                print("message")
            }

        }

    }

//    override fun chen() {
//        println("Imple's chen")
////        super<TestInterface>.chen()
////        super<Impl2>.chen()
//    }

}