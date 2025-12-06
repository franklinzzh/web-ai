FROM eclipse-temurin:21-jre

ENV LANG=C.UTF-8
ENV LC_ALL=C.UTF-8

RUN mkdir -p /app
WORKDIR /app

COPY /web-ai/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]


# # Use ubuntu
# FROM ubuntu:22.04

# # Add jdk-21 into image
# RUN mkdir -p /opt/jdk
# COPY jdk-21.tar.gz /opt/jdk
# RUN tar -xzf /opt/jdk/jdk-21.tar.gz -C /opt/jdk/ && rm /opt/jdk/jdk-21.tar.gz

# # Set Environment variable
# ENV JAVA_HOME=/opt/jdk/jdk-21.0.9
# ENV PATH="${JAVA_HOME}/bin:${PATH}"

# # Set working directory
# RUN mkdir -p /app
# WORKDIR /app

# # Copy the JAR file from your local machine into the image
# COPY ./web-ai/target/web-ai-0.0.1-SNAPSHOT.jar app.jar

# # Expose app port
# EXPOSE 8080

# # Run the JAR
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]

