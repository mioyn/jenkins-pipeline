package com.app

import spock.lang.Shared

class PipelineSpec extends SpockTestBase{

    @Shared
    Pipeline pipeline

    def setup(){
        pipeline = new Pipeline(jScript)
    }

    def "test pipeline execution"(){
        when:
        pipeline.execute()
        then:
        noExceptionThrown()
    }
}
