FROM java:8
EXPOSE 8080
ADD /build/libs/FYP_Monolith.jar FYP_Monolith.jar
ENTRYPOINT ["java","-jar", "-Dspring.data.mongodb.uri=mongodb://mongodb","FYP_Monolith.jar"]