FROM java:8
EXPOSE 1234
ADD ../../../file-navigator-client/target/file-navigator-client-0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","file-navigator-client-0.1-SNAPSHOT.jar"]