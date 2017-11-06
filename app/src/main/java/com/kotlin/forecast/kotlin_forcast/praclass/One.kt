package com.kotlin.forecast.kotlin_forcast.praclass


open class One(flag: String) {

    val cflag = flag;

    public var test: String = "abcd"
        get() = test.toUpperCase()
        set (value) {
//            test = value
            if (test.equals("abcd")) {
                field = "aaa"
            } else {
                field = "bbb"
            }
        }

    init {
        println("cflag is $test")

//        val east = EnumClassTest.EAST

    }

    constructor() : this(flag = "no arg"){

    }

    constructor(arg: Int) : this(flag = "abc") {
        println("arg is $arg")
    }

    constructor(c: Char) : this(arg = 5) {
        println("c is $c")
    }


}