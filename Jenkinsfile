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
                sh('cd demo/ && ./mvnw clean install')
            }
        }
        stage('Docker Build Image') {
            steps {
                sh('echo ')
                sh('sudo docker build -t $IMAGE_NAME:$COMMIT_ID .')
                sh('sudo docker tag demo-ci-pipline:$COMMIT_ID locnb1995/demo-ci-pipline:$COMMIT_ID')
            }
        }
        stage('Push Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'fbeae83f-df3a-45f7-b405-174e88f50acb', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh('sudo docker login -u $USERNAME -p $PASSWORD')
                }
                sh('sudo docker push locnb1995/$IMAGE_NAME:$COMMIT_ID')
            }
        }
        stage('Update helm image tag'){
            steps {
                sh('echo image tag $COMMIT_ID will update for tag')
                sh('sudo rm -r -f helm-CI-CD/')
                sh('sudo git clone https://github.com/locnb1995/helm-CI-CD')
                dir('helm-CI-CD'){
                    sh('echo working_dir $(pwd)')
                    sh("""sudo yq -i e '.image.tag = "$COMMIT_ID"' helm-for-demo-cicd/values.yaml""")
                    /*sh('git config --global --add safe.directory $(pwd)')
                    sh('git status')
                    sh('sudo git add .')
                    sh('sudo git commit -m "update image tag"')
                    sh('sudo git push orgin main')*/
                }
            }
        }
    }
}
