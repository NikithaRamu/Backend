FROM openjdk:11.0-jre
WORKDIR usr/src
ADD ./target/EurekaService-0.0.1-SNAPSHOT.jar /usr/src/EurekaService-0.0.1-SNAPSHOT.jar
RUN chmod +x /usr/src/EurekaService-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-Xmx200m","-jar","/usr/src/EurekaService-0.0.1-SNAPSHOT.jar"]