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
                            script {
                                echo "Do Build for ${PLATFORM} - ${JAVA_VERSION}"
                                bat "mvn clean compile package"
                            }
                        }
                    }
                    stage("Test") {
                        steps {
                            script {
                                echo "Do Test for ${PLATFORM} - ${JAVA_VERSION}"
                                bat "mvn test"
                            }
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
