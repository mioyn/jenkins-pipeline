package com.app.util

import org.codehaus.groovy.runtime.StackTraceUtils

import java.time.LocalDateTime

class Logger {
    private def jScript
    private static Level logLevel

    enum Level {
        DEBUG,
        INFO,
        WARN,
        ERROR
    }

    Logger(def jScript){
        this.jScript = jScript
    }

    static def setLevel(String lvl){
        switch (lvl.toUpperCase()){
            case 'DEBUG':
                logLevel = Level.DEBUG
                break
            case 'INFO':
                logLevel = Level.INFO
                break
            case 'WARN':
                logLevel = Level.WARN
                break
            case 'ERROR':
                logLevel = Level.ERROR
                break
            default:
                logLevel = Level.INFO
        }
    }

    def debug(String message) {
        message = genMessage("DEBUG", message)
        if (logLevel ==Level.DEBUG)
            coloredEcho {ColorFormat.boldBlackPageUp(message)}
    }

    def info(String message) {
        message = genMessage("INFO", message)
        if (logLevel ==Level.DEBUG || logLevel ==Level.INFO)
            coloredEcho {ColorFormat.boldBlackPageUp(message)}
    }
    def warn(String message) {
        message = genMessage("WARN", message)
        if (logLevel ==Level.DEBUG || logLevel ==Level.INFO || logLevel ==Level.WARN)
            coloredEcho {ColorFormat.boldYellowWarn(message)}
    }
    def error(String message) {
        message = genMessage("ERROR", message)
        coloredEcho {ColorFormat.boldRedCross(message)}
    }

    def success(String message) {
        coloredEcho {ColorFormat.boldGreenCheck(message)}
    }

    private def static genMessage(def logMethod, def message) {
        StackTraceElement[] stackTraceElements = StackTraceUtils.sanitize(new Throwable()).stackTrace

        return (logLevel == Level.DEBUG || logLevel == Level.ERROR)
                ? "${LocalDateTime.now()} [$logMethod] ${stackTraceElements[2].className}.${stackTraceElements[2].methodName} (${stackTraceElements[2].fileName}:${stackTraceElements[2].lineNumber}) $message"
                : "${LocalDateTime.now()} [$logMethod] $message"
    }

    private coloredEcho(def callback){
        jScript.echo(callback())
    }
}
