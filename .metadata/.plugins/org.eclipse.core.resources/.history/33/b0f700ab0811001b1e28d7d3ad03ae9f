FROM openjdk:11.0-jre
WORKDIR usr/src
ADD ./target/GipherManager-0.0.1-SNAPSHOT.jar /usr/src/GipherManager-0.0.1-SNAPSHOT.jar
RUN chmod +x /usr/src/GipherManager-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java","-Xmx200m","-jar","/usr/src/GipherManager-0.0.1-SNAPSHOT.jar"]