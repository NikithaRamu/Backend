FROM openjdk:11.0-jre
WORKDIR usr/src
ADD ./target/ZuulService-0.0.1-SNAPSHOT.jar /usr/src/ZuulService-0.0.1-SNAPSHOT.jar
RUN chmod +x /usr/src/ZuulService-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-Xmx200m","-jar","/usr/src/ZuulService-0.0.1-SNAPSHOT.jar"]