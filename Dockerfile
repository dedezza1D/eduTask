# Use uma imagem base oficial do Java
FROM openjdk:17

# Copie o arquivo jar para o container
COPY target/edutask-service-0.0.1-SNAPSHOT.jar /app/edutask.jar

# Configura a porta em que o aplicativo irá rodar
EXPOSE 8080

# Comando para executar o aplicativo
CMD ["java", "-jar", "/app/edutask.jar"]
