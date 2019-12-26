package com.github.yannicklamprecht.kotlininvocationhandler.example

import com.github.yannicklamprecht.kotlininvocationhandler.proxy.DefaultTypes
import com.github.yannicklamprecht.kotlininvocationhandler.proxy.proxy

open class Example {
    fun play(text: String) {
        println("play called")
    }

    fun play() {
        println("No Args call")
    }

}


fun main() {
    val ex: Example = Example().proxy(DefaultTypes::logging)

    ex.play("Hello")
    ex.play()
}

