FROM eclipse-temurin:25-jdk-alpine
RUN apk add bash
WORKDIR /lab
RUN mkdir -p /lab/bin 
