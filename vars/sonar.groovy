def call() {
    sh "mvn clean verify sonar:sonar \
    -Dsonar.host.url=$sonar_url \
    -Dsonar.projectName=ss"
    }



// // Define a function for SonarQube integration
// def sonarIntegration() {
//     echo "SonarQube Integration: Analyzing the code"

//     // Configure SonarQube environment
//     withSonarQubeEnv(credentialsId: 'sonar', installationName: 'sonarqube') {
//         // Run Maven with SonarQube analysis
//         sh """
//             mvn clean verify sonar:sonar \
//             -Dsonar.host.url=$sonar_url \
//             -Dsonar.projectName=$sonar_name
//         """
//     }
// }

// // Call the SonarQube integration function
// sonarIntegration()
