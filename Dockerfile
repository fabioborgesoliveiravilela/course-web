FROM adoptopenjdk/maven-openjdk11
WORKDIR /app
COPY ./ /app

RUN /app/run-build.sh

CMD java -jar -Dspring.profiles.active=postgres /app/target/course-web-0.0.1-SNAPSHOT.jar