package com.app.util

class ColorFormat {
    static String BOLD = '1;'
    static String NORMAL = '0;'
    static String UNDERLINE = '4;'
    static String BLINK = '5;'

    static String BLACK = "30m"
    static String RED = "31m"
    static String GREEN = "32m"
    static String YELLOW = "33m"

    static String PAGE_PACING_UP = ""
    static String CROSS_MARK = ""
    static String WARNING = ""
    static String CHECK_MARK = ""

    static String format(String weight, String color, String message) {
        def begin = "\u001B["
        def end = "\u001B[0m"
        begin + weight + color + message + end
    }

    static String boldRedCross(message) {
        format(BOLD, RED, CROSS_MARK + "$message")
    }

    static String boldGreenCheck(message) {
        format(BOLD, GREEN, CHECK_MARK + "$message")
    }

    static String boldYellowWarn(message) {
        format(BOLD, YELLOW, WARNING + "$message")
    }

    static String boldBlackPageUp(message) {
        format(BOLD, BLACK, PAGE_PACING_UP + "$message")
    }
}
