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
               
                	
   		            sh 'mvn clean compile'   
                
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
            
         stage('Security Scanning') {
             steps {
	             sh 'mvn findbugs:findbugs'  //   
             }
           }
           
        stage('Build War') {
             steps {
	             sh 'mvn war:war -Dmaven.test.skip=true'  //   
             }
           }
        stage('Tomcat Deploy') {
            steps {
               sh 'rm /opt/tomcat/apache-tomcat-9.0.20/webapps/spring-petclinic-2.1.0.BUILD-SNAPSHOT.war'  
                sleep 10
               sh returnStatus: true, script: 'cp ./target/*.war /opt/tomcat/apache-tomcat-9.0.20/webapps'
               
               sleep 10
            }
        }
          stage('Functional Test') {
             steps {
	             sh 'mvn integration-test'  //   
             }
           }  
 stage('Jmeter Execution') {
            steps {
              sh 'mvn -DJmeterTestFile=pt_test_case.jmx -DRampUp=10 -DLoopcount=2 -DThreadcount=3 verify'
            }
        }

    }
}