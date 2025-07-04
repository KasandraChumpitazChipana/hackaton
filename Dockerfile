# Etapa 1: Build
FROM eclipse-temurin:17-jdk-alpine AS builder

WORKDIR /app

# Copiar archivos de Maven
COPY pom.xml .
COPY src ./src

# Construir la aplicación
RUN ./mvnw clean package -DskipTests

# Etapa 2: Crear imagen final con scratch
FROM gcr.io/distroless/java17-debian11:nonroot

# Crear usuario no root
USER nonroot

# Copiar el JAR desde la etapa de build
COPY --from=builder /app/target/*.jar /app/app.jar

# Exponer el puerto (se puede cambiar con variable de entorno)
EXPOSE 8080

# Definir variable de entorno para el puerto
ENV PORT=8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]