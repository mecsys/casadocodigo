FROM tomcat:8.5

MAINTAINER Isaac Mecchi

RUN ["rm", "-rf", "/usr/local/tomcat/webapps/ROOT/*"]
ADD target/casadocodigo.war /usr/local/tomcat/webapps/casadocodigo.war

CMD ["catalina.sh", "run"]
