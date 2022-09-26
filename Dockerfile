FROM openjdk:11
EXPOSE 8080
ADD target/demoRest.jar demoRest.jar
ENTRYPOINT ["java","-jar","/demoRest.jar"]