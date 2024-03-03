package com.demo.roombookingservice.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static com.demo.roombookingservice.constants.ResultInfoConstants.SUCEESS;

public class ResponseEntityUtil {

    public static ResponseEntity<String> getResponseEntity(final Object data) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ResultInfoBuilder.buildResult(SUCEESS, data));
    }
}
