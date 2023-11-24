pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                sh 'cd demo/ && ./mvnw clean install'
            }
        }
        stage('Docker Build') {
    	agent any
            steps {
                dockerImage = docker.build registry + ":$BUILD_NUMBER"
            }
        }
    }
}
