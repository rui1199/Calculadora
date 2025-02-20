# Usando a imagem do JDK 17 como base
FROM openjdk:17
WORKDIR /app

# Copiar o arquivo JAR gerado pelo Maven
COPY target/calculator-service-1.0-SNAPSHOT.jar app.jar

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
