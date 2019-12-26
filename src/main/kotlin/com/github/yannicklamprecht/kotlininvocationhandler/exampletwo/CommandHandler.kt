package com.github.yannicklamprecht.kotlininvocationhandler.exampletwo

import com.github.yannicklamprecht.kotlininvocationhandler.proxy.proxy
import java.lang.reflect.Method

class CommandHandler {
    private val commands: MutableMap<String, Command> = HashMap()
    private var handler: (((sender: User, args: Array<String>) -> Unit, Method?, Array<out Any>?) -> Any?)? = null

    fun addCommand(command: Command) {
        commands[command.name] = command
    }

    fun execute(sender: User, commandName: String, args: Array<String>) {
        commands[commandName]?.let { command ->
            if (sender.hasPermission(command.permission)) {
                val executor = handler?.let { command.executor.proxy(it) } ?: command.executor
                executor.invoke(sender, args)
            } else {
                println("No permission")
            }
        } ?: println("Command not found")
    }

    fun setProxy(proxy: ((originObject: (sender: User, args: Array<String>) -> Unit, method: Method?, args: Array<out Any>?) -> Any?)?) {
        this.handler = proxy
    }
}