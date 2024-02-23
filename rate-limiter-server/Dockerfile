FROM eclipse-temurin:21
RUN mkdir /opt/app
COPY build/libs/rate-limiter-0.0.1-SNAPSHOT.jar /opt/app
EXPOSE 8080
CMD ["java", "-jar", "/opt/app/rate-limiter-0.0.1-SNAPSHOT.jar", "--testapi.restclient.host=${host_addr}"]
