pipeline{
    agent {
        label "built-in"
    }
    tools {
        jdk "jdk17"
        maven "current"
    }
    stages{
        stage("Build"){
            steps{
                bat 'mvn clean compile'
            }
        }
        stage("Build"){
            steps{
                bat 'mvn test'
            }
        }
    }
}