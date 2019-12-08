package com.github.yannicklamprecht.kotlininvocationhandler.exampletwo

data class User(val name: String, val permissions: List<String>){
    fun hasPermission(permission: String): Boolean {
        return permissions.contains(permission)
    }
}