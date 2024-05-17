pipeline {
    agent any

    stages {
        stage('Build tests zip with dependencies') {
            steps {
                sh 'gradlew clean zip'
            }
        }
    }
}