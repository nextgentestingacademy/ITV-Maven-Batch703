pipeline {
    agent any
    
    parameters{
		choice(
			name: 'BROWSER',
			choices: ['chrome', 'edge', 'firefox', 'ie'],
			description: 'Select the browser to run the tests on'
		)
		choice(
			name: 'ENVIRONMENT',
			choices: ['qa', 'prod', 'uat'],
			description: 'Select the environment to run the tests'
		)
	}
    

    tools {
        jdk 'Java_JDK'
        maven 'MAVEN'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/nextgentestingacademy/ITV-Maven-Batch703.git',
                    branch: 'main'
            }
        }

        stage('Build & Test') {
            steps {
                bat "mvn clean test -Dbrowser=${params.BROWSER} -Denvironment=${params.ENVIRONMENT}"
            }
        }
    }
}