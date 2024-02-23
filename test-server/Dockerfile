FROM eclipse-temurin:21
RUN mkdir /opt/app
COPY build/libs/test-api-0.0.1-SNAPSHOT.jar /opt/app
EXPOSE 8090
CMD ["java", "-jar", "/opt/app/test-api-0.0.1-SNAPSHOT.jar"]
