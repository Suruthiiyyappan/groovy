def mvnbuild() {
    if (ENV == 'mule') {
        sh 'mvn clean package'
        archiveJar()
    } else {
        echo 'not build'
    }
}

def archiveJar() {
    archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
}

def sonar() {
    sh "mvn clean verify sonar:sonar \
    -Dsonar.host.url=$sonar_url \
    -Dsonar.projectName=ss"
    }

def qualitygate() {
    timeout(time: 1, unit: 'HOURS') { 
        waitForQualityGate abortPipeline: true
            def qg = waitForQualityGate()
            if (qg.status != 'OK') {
                error "Quality gate not OK: ${qg.status}"
            }
    }
}
return this
