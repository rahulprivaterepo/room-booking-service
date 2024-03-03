package com.demo.roombookingservice.constants;

import com.demo.roombookingservice.domain.response.ResultInfo;

public class ResultInfoConstants {

    public static final ResultInfo SUCEESS =
            ResultInfo.builder()
                    .codeId("00000")
                    .code("SUCCESS")
                    .message("Successful Request")
                    .status("S")
                    .build();
}
