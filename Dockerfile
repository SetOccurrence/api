# Use a imagem oficial do OpenJDK como base
FROM openjdk:17-jdk-alpine

# Diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR construído pelo Gradle para o diretório de trabalho no container
COPY build/libs/api-0.0.1-SNAPSHOT.jar /app/api-0.0.1-SNAPSHOT.jar

# Porta que a aplicação Spring irá expor
EXPOSE 8080

# Comando para iniciar a aplicação Spring
CMD ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]