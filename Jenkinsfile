pipeline {
    agent any

    stages {
        stage('Build tests zip with dependencies') {
            sh 'gradlew clean zip'
        }
    }
}