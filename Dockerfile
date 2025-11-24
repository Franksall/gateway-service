#  Java 17.
FROM eclipse-temurin:17-jdk-alpine


LABEL maintainer="Franksall"

#  CONFIGURACIÓN
WORKDIR /app

#  COPIAR EL CÓDIGO

COPY build/libs/*.jar app.jar

#  EXPOSICIÓN
#  Puerto 8080 del Gateway.
EXPOSE 8080

#  EJECUCIÓN
ENTRYPOINT ["java", "-jar", "/app/app.jar"]