def call() {
    timeout(time: 1, unit: 'HOURS') { 
        waitForQualityGate abortPipeline: true
            def qg = waitForQualityGate()
            if (qg.status != 'OK') {
                error "Quality gate not OK: ${qg.status}"
            }
    }
}
