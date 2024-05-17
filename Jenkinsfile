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
                        username: 'ppetrachenkau_iam',
                        password: '7663337fiLL4',

                        appiumJavaTestNGTest: '',
                        appiumNodeTest: '',
                        appiumPythonTest: '',
                        appiumRubyTest: '',
                        appiumVersionJunit: '',
                        appiumVersionPython: '',
                        appiumVersionTestng: '',
                        calabashFeatures: '',
                        calabashProfile: '',
                        calabashTags: '',
                        deviceLatitude: 47.6204,
                        deviceLocation: false,
                        deviceLongitude: -122.3941,
                        eventCount: '',
                        eventThrottle: '',
                        extraData: false,
                        extraDataArtifact: '',
                        ifBluetooth: true,
                        ifGPS: true,
                        ifNfc: true,
                        ifSkipAppResigning: false,
                        ifVpce: false,
                        ifWebApp: false,
                        ifWifi: true,
                        ignoreRunError: false,
                        junitArtifact: '',
                        junitFilter: '',
                        radioDetails: false,
                        seed: '',
                        uiautomationArtifact: '',
                        uiautomatorArtifact: '',
                        uiautomatorFilter: '',
                        vpceServiceName: '',
                        xctestArtifact: '',
                        xctestFilter: '',
                        xctestUiArtifact: '',
                        xctestUiFilter: ''
            }
        }
    }
}