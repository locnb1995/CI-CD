pipeline {
    agent { label 'jenkins-build-agent-1' }
    environment { 
        COMMIT_ID = """${sh(
                returnStdout: true,
                script: 'git rev-parse HEAD'
            )}"""
    }

    stages {
        stage('Maven Build') {
            steps {
                sh ('cd demo/ && ./mvnw clean install')
            }
        }
        stage('Docker Build Image') {
            steps {
                sh ('echo ')
                sh ('sudo docker build -t demo-ci-pipline:$COMMIT_ID .')
                sh ('sudo docker tag demo-ci-pipline:$COMMIT_ID locnb1995/demo-ci-pipline:$COMMIT_ID')
            }
        }
    }
}
