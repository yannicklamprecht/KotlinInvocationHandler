package com.github.yannicklamprecht.kotlininvocationhandler.exampletwo

@FunctionalInterface
interface CommandExecutor {
    fun execute(sender: User, args: Array<String>)
}