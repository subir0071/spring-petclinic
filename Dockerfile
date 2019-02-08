FROM tomcat:8.0.20-jre8

COPY ./target/*.war /usr/local/tomcat/webapps/petclinic.war

EXPOSE 8080

CMD chmod +x /usr/local/tomcat/bin/catalina.sh

CMD ["catalina.sh", "run"]
 
