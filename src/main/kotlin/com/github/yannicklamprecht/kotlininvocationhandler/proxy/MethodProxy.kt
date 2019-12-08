package com.github.yannicklamprecht.kotlininvocationhandler.proxy


import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

inline fun <reified T : Any> T.proxy(noinline handler: (originObject: T, method: Method?, args: Array<out Any>?) -> Any?): T {
    return Proxy.newProxyInstance(
            javaClass.classLoader,
            arrayOf(T::class.java),
        KnowingInvocationHandler(
            this,
            handler
        )
    ) as T
}

class KnowingInvocationHandler<T>(
        private val originObject: T,
        private val handler: (originObject: T, method: Method?, args: Array<out Any>?) -> Any?
) : InvocationHandler {
    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
        return handler.invoke(originObject, method, args)
    }
}


