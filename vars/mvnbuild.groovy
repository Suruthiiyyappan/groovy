def call() {
    if (ENV == 'mule') {
        sh 'mvn clean package'
    } else {
        echo 'not build'
    }
}


// def call() {
//     if (ENV == 'mule') {
//         sh 'mvn clean package'
//         archiveJar()
//     } else {
//         echo 'not build'
//     }
// }

// def archiveJar() {
//     archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
// }
