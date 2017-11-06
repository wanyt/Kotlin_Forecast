package com.kotlin.forecast.kotlin_forcast.inherit

class Son : Father {

    val sFather = "fa";

//    override val a = 10

    var son: Int
        get() = son
        set(value) {
            son += value
        }

    init {
        println("son's init code")
    }

    constructor(args: String) : super(a = "father's son") {
        println("son's constructor")
    }

    fun sTest() {
        println(son)
    }

    override fun sameName() {
        super.sameName()
    }

    inner class SonInner {
        fun sonTest() {
            super@Son.sameName()

        }
    }

}