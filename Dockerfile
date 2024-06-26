# Use a imagem oficial do OpenJDK como base
FROM openjdk:17-jdk-alpine

# Diretório de trabalho dentro do container
WORKDIR /app

# Copia o Gradle Wrapper e define permissões de execução
COPY gradlew .
COPY gradle /app/gradle
RUN chmod +x gradlew

# Copia os arquivos de configuração do Gradle
COPY build.gradle .
COPY settings.gradle .

# Baixa as dependências
RUN ./gradlew dependencies --no-daemon

# Copia o código fonte da aplicação
COPY src ./src

# Realiza o build
RUN ./gradlew bootJar --no-daemon

# Porta que a aplicação Spring irá expor
EXPOSE 8080

# Comando para iniciar a aplicação Spring
ENTRYPOINT ["java", "-jar", "build/libs/api-0.0.1-SNAPSHOT.jar"]