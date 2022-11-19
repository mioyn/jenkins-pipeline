package com.app

import spock.lang.Specification

class SpockTestBase extends Specification {
    def jScript = new Expando()

    def setup(){
        mockWorkFlowScript()
    }

    def  mockWorkFlowScript() {
        jScript.metaClass.stage = { def arg, def callback ->
            println("TestBase stage")
            callback.call()
        }

        jScript.metaClass.echo = { def message ->
            println("TestBase echo")
            println message
        }
    }
}
