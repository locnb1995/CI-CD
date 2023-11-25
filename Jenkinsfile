pipeline {
    agent { label 'jenkins-build-agent-1' }

    stages {
        stage('Maven Build') {
            steps {
                sh 'cd demo/ && ./mvnw clean install'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'sudo docker build -t demo-ci-pipline .'
            }
        }
    }
}
