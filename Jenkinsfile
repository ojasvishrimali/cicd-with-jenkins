pipeline {
    agent any
    tools{
        maven 'maven-3.9.5'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ojasvishrimali/cicd-with-jenkins']]])
                sh 'mvn clean package'
                echo 'Build completed'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                sh 'mvn test'
                echo 'Testing completed'
            }
        }
    }
}