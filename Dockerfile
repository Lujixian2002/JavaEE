FROM maven:3.9-amazoncorretto-17 as builder
LABEL authors="cinea"

WORKDIR /app

COPY pom.xml ./
COPY . .

RUN mvn -B package

FROM amazoncorretto:17-alpine3.18
LABEL authors="cinea"

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 9001
ENTRYPOINT ["java","-jar","app.jar"]


