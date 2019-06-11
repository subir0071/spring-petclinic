pipeline {
    agent {
        node { 
  		label 'master'
  		
  	    } 

    }
    
    options{
  	buildDiscarder(logRotator(numToKeepStr:'5'))
  	timeout(time : 30, unit: 'MINUTES')
  }

      tools
	{
		maven 'MAVEN_HOME'
		jdk 'JAVA_HOME'
	}
    
    stages {
    
        stage('build') {
            steps {
                  deleteDir()
		          git(url: 'https://github.com/subir0071/spring-petclinic.git', branch: 'master', credentialsId: '')

            }
        }
        
        stage('Build') {
            steps {
               
                echo "maven clean build"
               
                	
   		            sh 'mvn clean compile'   
                
            }
        }  
        
        stage('SCA_Sonar') {
            steps {
                    
   		            sh 'mvn sonar:sonar -Dsonar.host.url=http://http://52.172.195.61:9000/'
            }
        }
        
        stage('Test') {
            steps {
                
                    
                    sh 'mvn test'
               
	        }
        }
        
        stage('code_coverage') {
            steps {
                jacoco(deltaBranchCoverage: '10', deltaClassCoverage: '10', deltaComplexityCoverage: '10', deltaInstructionCoverage: '10', deltaLineCoverage: '10', deltaMethodCoverage: '20')
            }
        }
            
         stage('Security Scanning') {
             steps {
	             sh 'mvn spotbugs:check'  //   findbugs:findbugs
             }
           }
        
        stage('Tomcat Deploy') {
            steps {
               sh returnStatus: true, script: 'copy .\\target\\petclinic.war D:\\Prog_Files\\Tomcat\\apache-tomcat-8.5.34\\webapps\\'
            }
        }


    }
}
