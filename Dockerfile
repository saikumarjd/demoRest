FROM openjdk:11
EXPOSE 8080
ADD target/springrestimage.jar springrestimage.jar
ENTRYPOINT ["java","-jar","/springrestimage.jar"]