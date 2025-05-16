pipeline {
    agent any
    
    environment {
        BASE_URL = 'http://localhost:8000'
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/your-repo/bookstore-api-tests.git'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'allure-results']]
                    ])
                }
            }
        }
        
        stage('Report') {
            steps {
                sh 'mvn allure:report'
                archiveArtifacts artifacts: 'target/allure-report/**', fingerprint: true
            }
        }
    }
    
    post {
        always {
            cleanWs()
        }
    }
}
