FROM openjdk:17
ADD /build/libs/room-booking-service-2.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]