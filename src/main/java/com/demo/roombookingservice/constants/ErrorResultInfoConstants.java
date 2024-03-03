package com.demo.roombookingservice.constants;

import com.demo.roombookingservice.domain.response.ResultInfo;

import static com.demo.roombookingservice.constants.ExceptionConstants.ROOMS_NOT_AVAILABLE_EXCEPTION;
import static com.demo.roombookingservice.constants.ExceptionConstants.ROOM_ADD_EXCEPTION;
import static com.demo.roombookingservice.constants.ExceptionConstants.ROOM_REMOVAL_EXCEPTION;

public class ErrorResultInfoConstants {

    public static final ResultInfo ROOMS_UNAVAILABLE_ERROR =
            ResultInfo.builder()
                    .code("ROOMS_UNAVAILABLE_ERROR")
                    .codeId("001")
                    .message(ROOMS_NOT_AVAILABLE_EXCEPTION)
                    .status("F")
                    .build();

    public static final ResultInfo ROOM_ADD_ERROR =
            ResultInfo.builder()
                    .code("ROOM_ADD_ERROR")
                    .codeId("002")
                    .message(ROOM_ADD_EXCEPTION)
                    .status("F")
                    .build();

    public static final ResultInfo ROOM_REMOVAL_ERROR =
            ResultInfo.builder()
                    .code("ROOM_REMOVAL_ERROR")
                    .codeId("003")
                    .message(ROOM_REMOVAL_EXCEPTION)
                    .status("F")
                    .build();

}
