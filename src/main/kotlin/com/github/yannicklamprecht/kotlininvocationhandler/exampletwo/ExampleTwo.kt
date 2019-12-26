package com.github.yannicklamprecht.kotlininvocationhandler.exampletwo

import com.github.yannicklamprecht.kotlininvocationhandler.proxy.DefaultTypes

fun main() {

    val exampleTwo = ExampleTwo()

}


class ExampleTwo {

    init {
        val handler = CommandHandler()
        val command = Command("test", "command.test", executor = { _: User, _: Array<String> -> println("[TestExecutor] execute called")})
        val user = User("name", listOf("command.test"))
        handler.addCommand(command)
        val name = "test"
        val param: Array<String> = arrayOf("hello", "welcome", "to", "Germany")

        handler.execute(user, name, param)
        handler.setProxy(DefaultTypes::logging)
        handler.execute(user, name, param)
    }

}


