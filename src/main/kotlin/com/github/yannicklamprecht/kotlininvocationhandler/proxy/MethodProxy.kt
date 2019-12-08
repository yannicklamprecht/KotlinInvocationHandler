package com.github.yannicklamprecht.kotlininvocationhandler.proxy


import java.lang.reflect.Method
import java.lang.reflect.Proxy

inline fun <reified T : Any> T.proxy(noinline handler: (originObject: T, method: Method?, args: Array<out Any>?) -> Any?): T {
    return Proxy.newProxyInstance(
        javaClass.classLoader,
        arrayOf(T::class.java)
    ) { _, method, args -> handler(this, method, args) } as T
}


