package com.github.yannicklamprecht.kotlininvocationhandler.proxy

import com.github.yannicklamprecht.generics.getClassName
import com.github.yannicklamprecht.generics.simpleName
import java.lang.reflect.Method

object DefaultTypes {
    inline fun <reified T> logging(caller: T, method: Method?, args: Array<out Any>?): Any? {
        val className = caller.getClassName().simpleName()
        println("[${className}] Entering method: ${method?.name} with argsCount: ${args?.size ?: 0}")
        args?.let { println("Arguments: ${it.humanReadable()}") }
        val result = if (args?.isNotEmpty() == true) method?.invoke(caller, *args) else method?.invoke(caller)
        println("[${className}] Exiting method: ${method?.name}")
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


