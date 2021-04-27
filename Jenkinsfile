
pipeline {
    agent any
    tools{
        maven 'Maven'
    }
    stages {  
        stage('Quality check'){
            steps{
                echo 'Quality check with Sobarqube'
                sh 'mvn sonar:sonar -Dsonar.projectKey=FOREX -Dsonar.host.url=http://167.99.252.236:9000 -Dsonar.login=a9440b3640695f1a128d67ee8f58f8199b858733'
            }
        }

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
