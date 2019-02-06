FROM tomcat:8.0.20-jre8

RUN mkdir /usr/local/tomcat/webapps/myapp

COPY ./target/*.war /usr/local/tomcat/webapps/myapp/petclinic.war
