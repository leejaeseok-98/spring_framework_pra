
FROM maven:3.9-eclipse-temurin-17 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM tomcat:9.0.112-jdk17-temurin
  
  # 1. 기존 톰캣의 ROOT 폴더 삭제 (내 앱을 ROOT로 쓰기 위해)
RUN rm -rf /usr/local/tomcat/webapps/ROOT

  # 2. 빌드된 WAR 파일을 컨테이너의 톰캣 배포 폴더로 복사
COPY --from=builder /app/target/*.war /usr/local/tomcat/webapps/ROOT.war
  
  # 5. 톰캣 포트 노출 (기본 8080)
EXPOSE 8080
  
  # 6. 톰캣 실행 (베이스 이미지의 기본 CMD가 catalina.sh run 이므로 생략 가능하나 명시적 표현)
CMD ["catalina.sh", "run"]