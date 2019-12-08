package com.github.yannicklamprecht.generics


object Pattern {
    val REMOVE_ADDRESS = Regex("@\\w+$")
    val REMOVE_PACKAGE = Regex("(\\w+\\.)+")
}

fun <T> T.getClassName(): String {
    return this.toString().replace(Pattern.REMOVE_ADDRESS, "")
}

fun String.simpleName(): String {
    return this.replace(Pattern.REMOVE_PACKAGE, "")
}