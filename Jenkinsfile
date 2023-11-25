pipeline {
    agent 'jenkins-build-agent-1'

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
