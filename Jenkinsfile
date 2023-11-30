pipeline{
    agent {
        label "built-in"
    }
    tools {
        jdk "jdk17"
    }
    stages{
        stage("Build"){
            steps{
                bat 'java -version'
            }
        }
    }
}