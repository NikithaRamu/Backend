FROM openjdk:11.0-jre
WORKDIR usr/src
ADD ./target/RecommendationSystem-0.0.1-SNAPSHOT.jar /usr/src/RecommendationSystem-0.0.1-SNAPSHOT.jar
RUN chmod +x /usr/src/RecommendationSystem-0.0.1-SNAPSHOT.jar
EXPOSE 8083
ENTRYPOINT ["java","-Xmx200m","-jar","/usr/src/RecommendationSystem-0.0.1-SNAPSHOT.jar"]