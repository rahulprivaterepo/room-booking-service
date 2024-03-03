package com.demo.roombookingservice.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Optional;

public class DateTimeUtil {

    public static ZonedDateTime getZonedDateTime(LocalDateTime localDateTime) {
        if(Optional.ofNullable(localDateTime).isEmpty()) {
            return null;
        }
        return ZonedDateTime.of(localDateTime, ZoneOffset.UTC);
    }
}
