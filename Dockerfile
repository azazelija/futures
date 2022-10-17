FROM openjdk:19
ADD target/futures-1.0.jar futures-1.0.jar
EXPOSE ${APP_PORT}
ENTRYPOINT ["java","-jar","futures-1.0.jar"]