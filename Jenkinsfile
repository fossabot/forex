
pipeline {
    agent any
    tools{
        maven 'Maven'
    }
    stages {  
        stage('Build') {
            steps {
                echo 'Building stage ..'
                sh "mvn clean install"
            }
        }
        
        stage('Test') {
            steps {
                echo 'Testing stage..'
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploying stage..'
            }
        }
        stage('Clean up') {
            steps {
                echo 'Cleanup stage..'
            }
        }
    }
}

