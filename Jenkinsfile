pipeline {
    agent { label 'jenkins-build-agent-1' }
    environment { 
        COMMIT_ID = """${sh(
                returnStdout: true,
                script: 'git rev-parse HEAD'
            )}"""
        IMAGE_NAME = 'demo-ci-pipline'
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
                sh ('sudo docker build -t $IMAGE_NAME:$COMMIT_ID .')
                sh ('sudo docker tag demo-ci-pipline:$COMMIT_ID locnb1995/demo-ci-pipline:$COMMIT_ID')
            }
        }
        stage('Push Image') {
            steps {
                sh ('sudo docker push locnb1995/cicd-repo:$IMAGE_NAME:$COMMIT_ID')
            }
        }
    }
}
