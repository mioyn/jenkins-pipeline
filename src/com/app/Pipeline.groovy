package com.app

import com.app.util.Logger

class Pipeline {
    def jScript

    Logger logger
    Pipeline(def jScript) {
        this.jScript = jScript
        this.logger = new Logger(jScript)
    }

    def execute() {
        Logger.setLevel("INFO")
        jScript.stage("Build"){
            logger.info("Stage Execution")
        }
    }
}
