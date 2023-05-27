FROM openjdk
ARG JAR_FILE=target/before-getting-job-0.0.1-SNAPSHOT.jar
WORKDIR before-getting-job
COPY ${JAR_FILE} app.jar
CMD java -jar app.jar