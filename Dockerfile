# Use ubuntu
FROM ubuntu

# Add jdk-21 into image
COPY jdk-21.tar.gz /opt/jdk
RUN tar -xzf /usr/local/jdk-21.tar.gz -C /usr/local/ &&  rm /usr/local/jdk17.tar.gz
jdk-21.0.9.jdk
# Set working directory
WORKDIR /app

# Copy the JAR file from your local machine into the image
COPY target/myapp.jar app.jar

# Expose app port
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]

