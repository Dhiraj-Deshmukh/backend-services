
LABEL folder=clinicomply-admin-service
WORKDIR /home/app/clinicomply-admin-service


COPY ./clinicomply-admin-service/pom.xml ./clinicomply-admin-service/pom.xml
RUN mvn -f ./clinicomply-admin-service/pom.xml dependency:resolve

COPY ./clinicomply-admin-service/src ./clinicomply-admin-service/src
ARG SPRING_PROFILES_ACTIVE
ARG AWS_ACCESS_KEY_ID
ARG AWS_SECRET_ACCESS_KEY
RUN mvn -f ./clinicomply-admin-service/pom.xml clean install

FROM amazoncorretto:21.0.3-alpine
EXPOSE 9001
WORKDIR /home/deployment
RUN apk update && apk upgrade \
   && apk add --no-cache ttf-dejavu \
   && apk add --no-cache msttcorefonts-installer \
   && update-ms-fonts && fc-cache -f
COPY ./clinicomply-admin-service/deployment/*  ./
COPY --from=build /home/app/clinicomply-admin-service/clinicomply-admin-service/target/*.jar ./admin-service.jar

ENTRYPOINT [ "sh", "-c", "java -Dlogging.config=file:./logback.xml -jar ./admin-service.jar" ]