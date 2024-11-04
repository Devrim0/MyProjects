# Kullanılacak baz image
FROM openjdk:17-jdk-slim

# Uygulama JAR dosyasının kopyalanması
COPY target/user-service-1.0-SNAPSHOT.jar user-service.jar

# Uygulamanın çalıştırılması
ENTRYPOINT ["java", "-jar", "user-service.jar"]
