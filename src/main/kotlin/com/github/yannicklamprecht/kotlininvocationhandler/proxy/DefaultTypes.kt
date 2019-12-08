package com.github.yannicklamprecht.kotlininvocationhandler.proxy

import java.lang.reflect.Method

object DefaultTypes {
    fun <T> logging(caller: T, method: Method?, args: Array<out Any>?): Any? {
        println("Entering method: ${method?.name} with argsCount: ${args?.size ?: 0}")
        args?.let { println("Arguments: ${it.humanReadable()}") }
        val result = if (args?.isNotEmpty() == true) method?.invoke(caller, *args) else method?.invoke(caller)
        println("Exiting method: ${method?.name}")
        return result
    }
}

fun <T> Array<T>.humanReadable(): String {
    return "[${this.joinToString(separator = ", ") {

        if ( it is Array<*>){
            return@joinToString "${it.javaClass.simpleName}(elements=${it.humanReadable()})"
        }
        it.toString()
    }}]"
}

fun String.toString(): String {
    return this
}
