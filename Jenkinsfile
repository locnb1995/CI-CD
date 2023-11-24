pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                sh 'cd demo/ && ./mvnw clean install'
            }
        }
    }
}
