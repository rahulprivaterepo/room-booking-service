package com.demo.roombookingservice.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import net.minidev.json.JSONObject;

@Data
@Builder
@AllArgsConstructor
public class ResultInfo implements Serializable {
    private String codeId;
    private String code;
    private String message;
    private String status;


    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("codeId", codeId);
        jsonObject.put("code", code);
        jsonObject.put("message", message);
        jsonObject.put("status", status);
        return jsonObject.toJSONString();
    }
}
