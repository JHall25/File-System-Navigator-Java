FROM java:8
ADD ./file-navigator-client-0.1-SNAPSHOT.jar file-navigator-client-0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","file-navigator-client-0.1-SNAPSHOT.jar"]