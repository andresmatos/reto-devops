pipeline {

    environment {
        registry = "andresmatos/reto-devops"
        registryCredential = 'dockerhub'
        dockerImage = ''
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '3', artifactNumToKeepStr: '3'))
    }
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                echo 'mvn test'
            }
        }
        stage('Building image') {
            steps {
                script {
                        dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        stage('Push Image') {
              steps{
                script {
                  docker.withRegistry( '', registryCredential ) {
                    dockerImage.push()
                  }
                }
              }
         }

        stage('Remove Unused docker image') {
              steps{
                sh "docker rmi $registry:$BUILD_NUMBER"
              }
        }

        stage('Deploy') {
              steps{
                sh 'docker ps -f name=andresmatos/reto-devops -q | xargs --no-run-if-empty docker container stop'
                sh 'docker container ls -a -fname=andresmatos/reto-devops -q | xargs -r docker container rm'
                sh 'docker run -d -p 8081:8080 $registry:$BUILD_NUMBER'
              }
        }
    }
}