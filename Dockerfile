FROM openjdk:8-jdk-alpine
ADD target/orders-service-1.0.0.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n -Djava.security.egd=file:/dev/./urandom -jar /app.jar