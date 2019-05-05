# 将Homework2的rest service拆分为两个微服务
## Dockerfile
wordladder_function:
```
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD wordladder_function-1.0-SNAPSHOT.jar app.jar
ADD dictionary.txt dictionary.txt
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8080
```
  
wordladder_auth:
```
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD wordladder_auth-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8083
```

## images

wordladder_function为wordladder服务，wordladder_auth为验证登录服务。
在docker中输入以下命令:  
```
docker network create net
docker run --network net --name wordladder -p 8080 pythonmylife/wordladder_function
docker run --network net --name auth -p 8083 pythonmylife/wordladder_auth
```

之后在`http://192.168.99.100:8080/wordladder/search?str1=code&&str2=data`访问显示未登录请先登录  
在`http://192.168.99.100:8080/wordladder/login?name=user&&password=pass`访问显示true  
之后再访问`http://192.168.99.100:8080/wordladder/search?str1=code&&str2=data`显示wordladder  

采取的服务之间联系的方式为wordladder_function访问url`http://http://auth:8083/auth`,auth为docker中wordladder_auth的name。
