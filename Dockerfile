FROM openjdk:latest


# 设置工作目录
WORKDIR /app

# 将 Spring Boot 的 JAR 包复制到容器
COPY target/luckincoffee-0.0.1-SNAPSHOT.jar /app/app.jar

# 暴露 Spring Boot 项目使用的端口
EXPOSE 8080

# 启动命令
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
