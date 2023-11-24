FROM openjdk:11
COPY /target/demo-0.0.1-SNAPSHOT.jar /app
WORKDIR /app
CMD ["java","-jar","/app/demo-0.0.1-SNAPSHOT.jar"]