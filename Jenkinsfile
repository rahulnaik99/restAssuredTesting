pipeline {
    agent any

    environment {
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=true"
    }

    options {
        timestamps()
        parallelsAlwaysFailFast()
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/rahulnaik99/restAssuredTesting.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Parallel Tests') {
            parallel {
                stage('AddPlace Tests') {
                    steps {
                        sh 'mvn test -Dcucumber.filter.tags="@addPlace"'
                    }
                }
                stage('DeletePlace Tests') {
                    steps {
                        sh 'mvn test -Dcucumber.filter.tags="@deletePlace"'
                    }
                }
            }
        }

        stage('Generate Cucumber Report') {
            steps {
                sh 'mvn verify'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'target/cucumber-html-reports/*.html', allowEmptyArchive: true
                junit 'target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed.'
        }
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed.'
        }
    }
}
