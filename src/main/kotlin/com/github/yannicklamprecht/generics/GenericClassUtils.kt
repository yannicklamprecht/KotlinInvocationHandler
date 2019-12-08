package com.github.yannicklamprecht.generics

fun <T> T.getClassName(): String {
    return this.toString().replace(Regex("@\\w+$"), "")
}

fun String.simpleName(): String {
    return this.replace(Regex("(\\w+\\.)+"),"")
}