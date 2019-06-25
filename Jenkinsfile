pipeline {
    agent {
        node { 
  		label 'master'
  		
  	    } 
    }
    environment {
       myEnv_var = 'env Value'
    }
    
    options{
  	buildDiscarder(logRotator(numToKeepStr:'5'))
  	timeout(time : 30, unit: 'MINUTES')
  }

      tools
	{
		maven 'MAVEN_HOME'
		jdk 'java'
	}
    
    stages {
    
        stage('build') {
            steps {
                  deleteDir()
		          git(url: 'https://github.com/subir0071/spring-petclinic.git', branch: 'cumminsDemo', credentialsId: '')

            }
        }
        
        stage('Build') {
            steps {
               
                echo "maven clean build"
               
                	
   		            sh 'mvn clean compile -X'   
                
            }
        }  
		
		stage('parallel') {
			
			
			parallel {
                stage('Test On Windows') {
                    agent {
                        label "master"
                    }
                    steps {
                        sh 'running on master'
                    }
                    
                }
                stage('Test On Linux') {
                    agent {
                        label "linux"
                    }
                    steps {
                        sh 'echo Running on linux'
                    }
                    
                }
				
			}
				
		}
        
        stage('Test') {
            steps {
                
                    node ('linux') {
                    sh 'mvn test'
				}
               
	        }
        }
        
        stage('code_coverage') {
            steps {
                jacoco(deltaBranchCoverage: '10', deltaClassCoverage: '10', deltaComplexityCoverage: '10', deltaInstructionCoverage: '10', deltaLineCoverage: '10', deltaMethodCoverage: '20')
            }
        }
            
       

    }
}