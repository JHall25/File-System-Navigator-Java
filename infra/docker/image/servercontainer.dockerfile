FROM java:8
EXPOSE 1234
ADD ../../../file-navigator-server/target/file-navigator-server-0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","file-navigator-server-0.1-SNAPSHOT.jar"]