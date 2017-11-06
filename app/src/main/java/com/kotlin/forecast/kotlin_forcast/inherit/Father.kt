package com.kotlin.forecast.kotlin_forcast.inherit

open class Father {

    open val a = 5;

    init {
        println("father's init code block")
    }

    constructor(a: String){
        println("constructor String")
    }

    constructor(b: Int){
        println("constructor Int")
    }

    open fun sameName(){
        println("father's same name")
    }

}