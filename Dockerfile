#FROM openjdk:8
#COPY ./target/ea-lab1-0.0.1-SNAPSHOT.jar ea-lab1.jar
#CMD ["java","-jar","ea-lab1.jar"]

FROM openjdk:latest

ADD target/ea-lab1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8080