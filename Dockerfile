FROM npalm/java:oracle-java8
MAINTAINER Niek Palm "dev.npalm@gmail.com"

WORKDIR /build
COPY . /build

RUN ./gradlew build


WORKDIR /app
RUN mv /build/build/libs/base64encoder.jar /app && \
  rm -rf /build

ENTRYPOINT ["java", "-jar", "base64encoder.jar"]

