FROM tomcat:9-jdk8
COPY  target/laptops.war /usr/local/tomcat/webapps/laptops.war