# ETAPA 1: Imagem Base
# Começamos com uma imagem oficial que já tem o Java (OpenJDK 25) instalado.
# Usar 'eclipse-temurin' é uma prática moderna e segura.
FROM eclipse-temurin:25-jdk-jammy

# ETAPA 2: Diretório de Trabalho
# Cria uma pasta '/app' dentro do contêiner. Todo comando a seguir
# será executado a partir desta pasta.
WORKDIR /app

# ETAPA 3: Copiar o Arquivo .jar
# Copia o arquivo .jar, que foi gerado pelo comando 'mvn package' na pasta 'target',
# para dentro do contêiner e o renomeia para 'app.jar' para facilitar.
COPY target/*.jar app.jar

# ETAPA 4: Expor a Porta
# Informa ao Docker que a aplicação dentro do contêiner irá rodar na porta 8080.
EXPOSE 8080

# ETAPA 5: Comando de Execução
# Define o comando que será executado para iniciar a aplicação assim que o contêiner for ligado.
# É o equivalente a rodar 'java -jar app.jar' no terminal.
ENTRYPOINT ["java", "-jar", "app.jar"]