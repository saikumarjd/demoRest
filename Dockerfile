FROM openjdk:11
EXPOSE 8080
ADD src/springrestimage-0.0.1.jar springrestimage-0.0.1.jar
ENTRYPOINT ["java","-jar","/springrestimage-0.0.1.jar"]