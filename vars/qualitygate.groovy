def call() {
    def qg = waitForQualityGate()
    if (qg.status != 'OK') {
        error "Quality gate not OK: ${qg.status}"
    }
}



