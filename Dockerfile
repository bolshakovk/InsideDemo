FROM openjdk:11
ADD target/inside-app.jar inside-app.jar
ENTRYPOINT ["java", "-jar", "inside-app.jar"]