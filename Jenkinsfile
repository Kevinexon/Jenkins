pipeline {
    agent {
        label "built-in"
    }
    tools {
        jdk "jdk17"
        maven "current"
    }
    stages {
        stage("Build & Test") {
            matrix {
                axes {
                    axis {
                        name 'PLATFORM'
                        values 'linux', 'windows'
                    }
                    axis {
                        name 'JAVA_VERSION'
                        values 'jdk17', 'jdk11', 'jdk21'
                    }
                }
                stages {
                    stage("Build") {
                        steps {
                            // bat "mvn clean compile package"
                            echo "Do Build for ${PLATFORM} - ${JAVA_VERSION}"
                        }
                    }
                    stage("Test") {
                        steps {
                            // bat "mvn test"                            
                            echo "Test for ${PLATFORM} - ${JAVA_VERSION}"
                        }
                    }
                }
                excludes {
                    exclude {
                        axis {
                            name 'PLATFORM'
                            values 'linux'
                        }
                        axis {
                            name 'JAVA_VERSION'
                            values 'jdk11'
                        }
                    }
                    exclude {
                        axis {
                            name 'PLATFORM'
                            values 'windows'
                        }
                        axis {
                            name 'JAVA_VERSION'
                            values 'jdk11'
                        }
                    }
                }
            }
        }
    }
}
