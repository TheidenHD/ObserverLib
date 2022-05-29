pipeline {
  agent any
  environment {
    WEBHOOKURL = credentials('JenkinsDiscordWebhook')
  }
  stages {
    stage('Prepare Build') {
      steps {
        sh '''cp -a /var/lib/jenkins/buildMetadata/ObserverLib-1.18/. .
rm -rf README.md'''
      }
    }
    stage('Build') {
      steps {
        sh '''./gradlew build publish'''
      }
    }
    stage('Prepare Archive') {
      steps {
        sh '''cp -a ./build/libs/. .
rm -rf build gradle .gradle
find . ! -name \'*.jar\' -delete'''
      }
    }
    stage('Archive') {
      steps {
        archiveArtifacts '*.jar'
      }
    }
    stage('Notify') {
      steps {
        discordSendHellFire link: env.BUILD_URL, result: currentBuild.currentResult, webhookURL: "${WEBHOOKURL}"
      }
    }
  }
}
