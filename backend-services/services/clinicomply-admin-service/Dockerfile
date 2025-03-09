# Use Amazon Corretto 21 (Alpine) as the base image
FROM amazoncorretto:21.0.3-alpine

LABEL folder=clinicomply-admin-service

# Set working directory under a multi-service structure
WORKDIR /home/deployment/clinicomply-admin-service

# Expose the application port
EXPOSE 9001

# Install necessary dependencies (optional)
RUN apk update && apk upgrade \
   && apk add --no-cache ttf-dejavu \
   && apk add --no-cache msttcorefonts-installer \
   && update-ms-fonts && fc-cache -f

# Copy deployment-related files (if any)
COPY ./deployment/* ./deployment/

# Copy the built JAR file from Jenkins workspace
COPY ./target/*.jar ./clinicomply-admin-service.jar

# Command to run the application
ENTRYPOINT [ "sh", "-c", "java -Dlogging.config=file:./logback.xml -jar ./clinicomply-admin-service.jar" ]
