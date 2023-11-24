pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                sh 'pwd'
                echo 'Hello World from ci-pipeline'
                echo 'Add webhook from github to jenkins'
                sh 'docker --version'
            }
        }
    }
}
