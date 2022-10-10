FROM openjdk
MAINTAINER  Author Name <ojramirez@gmail.com>
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} krugerDeployable.jar
ENTRYPOINT ["java","-jar","/krugerDeployable.jar"]
