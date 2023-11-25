FROM openjdk:11
WORKDIR /app
COPY /demo/target/demo-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","/app/demo-0.0.1-SNAPSHOT.jar"]