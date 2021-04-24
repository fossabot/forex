pipeline {
    agent any
    tools{
        maven 'Maven'
    }
    stages {
        stage('SCM') {
                 git 'https://github.com/foo/bar.git'
                    }
    stage('SonarQube analysis') {
        withSonarQubeEnv('My SonarQube Server') {
        sh "mvn sonar:sonar -Dsonar.projectKey=FOREX -Dsonar.host.url=http://167.99.252.236:9000 -Dsonar.login=a9440b3640695f1a128d67ee8f58f8199b858733"
      //sh 'mvn clean package sonar:sonar'
    } // submitted SonarQube taskId is automatically attached to the pipeline context
  }
}
  
// No need to occupy a node
stage("Quality Gate"){
  timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
    def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
    if (qg.status != 'OK') {
      error "Pipeline aborted due to quality gate failure: ${qg.status}"
    }
  }
        
        //stage('Code Analysis'){
          //  steps{
            //    sh "mvn sonar:sonar -Dsonar.projectKey=FOREX -Dsonar.host.url=http://167.99.252.236:9000 -Dsonar.login=a9440b3640695f1a128d67ee8f58f8199b858733"    
           // }
       // }
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
