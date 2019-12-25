package com.github.yannicklamprecht.kotlininvocationhandler.example

import com.github.yannicklamprecht.kotlininvocationhandler.proxy.DefaultTypes
import com.github.yannicklamprecht.kotlininvocationhandler.proxy.proxy

class Example : Ex {
    override fun play(text: String) {
        println("play called")
    }

    override fun play() {
        println("No Args call")
    }

}


fun main() {
    val ex = Example().proxy<Ex>(DefaultTypes::logging)

    ex.play("Hello")
    ex.play()
}

