pipeline {
    agent any

    stages {
        stage('Maven Build') {
            steps {
                sh 'cd demo/ && ./mvnw clean install'
            }
        }
        stage('Docker Build') {
    	agent any
            steps {
                sh 'ls'
            }
        }
    }
}
