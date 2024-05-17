pipeline {
    agent any

    stages {

        stage('Build tests zip with dependencies') {
            steps {
                sh 'sh ./gradlew clean zip'
            }
        }

        stage('Run tests on AWS Device Farm') {
            steps {
                devicefarm projectName: 'MyDemoTests',
                        devicePoolName: 'TestingDevicePool',
                        appArtifact: './src/test/resources/app/mydemo.apk',
                        runName: '${BUILD_ID}_mydemo_tests',
                        testSpecName: 'junitTestRunner.yml',
                        appiumJavaJUnitTest: './build/libs/android_appium_mydemo.zip',
                        ifVideoRecording: false,
                        ifAppPerformanceMonitoring: false,
                        jobTimeoutMinutes: 10,
                        environmentToRun: 'ANDROID',
                        testToRun: 'APPIUM_JAVA_JUNIT',
                        storeResults: true,
                        resultsPath: './devicefarm-results',
                        archiveResults: true,
                        isRunUnmetered: false,
//                         eventCount: 1000,
//                         eventThrottle: 50,
//                         seed: 12345,
                        username: 'ppetrachenkau_iam'
            }
        }
    }
}