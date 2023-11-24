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
                sh 'docker --version'
            }
        }
    }
}
