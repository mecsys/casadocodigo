FROM tomcat:9

MAINTAINER Isaac Mecchi  <isaacmecchi@gmail.com>

RUN ["rm", "-rf", "/usr/local/tomcat/webapps/ROOT/*"]
ADD target/casadocodigo.war /usr/local/tomcat/webapps/casadocodigo.war

CMD ["catalina.sh", "run"]
