# Etapa 1: Build con Maven
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos de configuración
COPY pom.xml .
COPY src ./src

# Construye el proyecto y genera el jar
RUN mvn clean package -DskipTests

# Etapa 2: Imagen ligera para ejecución
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copia el jar desde el build stage
COPY --from=build /app/target/student-microservice-1.0.0.jar app.jar

# Puerto expuesto (por defecto 8080, puedes cambiar si usas otra config) | docker run -d --name student-container chumpitazkasandra/student:latest
# docker push chumpitazkasandra/student:latest
EXPOSE 8080

# Comando por defecto
ENTRYPOINT ["java", "-jar", "app.jar"]
