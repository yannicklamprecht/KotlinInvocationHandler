package com.github.yannicklamprecht.kotlininvocationhandler.exampletwo

class Command(val name: String, val permission: String, val executor: (sender: User, args: Array<String>) -> Unit)