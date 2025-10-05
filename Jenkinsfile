pipeline {
  agent any
  tools { maven 'Maven3' }
  stages {
    stage('Checkout') { steps { checkout scm } }
    stage('Build & Test') {
      steps {
        script {
          def cmd = 'mvn -B -DskipTests=false clean verify'
          if (isUnix()) { sh cmd } else { bat cmd }
        }
      }
    }
    stage('Publish Reports & Jar') {
      steps {
        junit '**/surefire-reports/*.xml'
        archiveArtifacts artifacts: 'target/*-shaded.jar', fingerprint: true
      }
    }
  }
}
