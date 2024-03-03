package com.demo.roombookingservice.util;

import com.demo.roombookingservice.domain.response.ResultInfo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResultInfoBuilder {

    public static String buildResult(final ResultInfo resultInfo, final Object data) {
        JsonNode jsonObject = JsonUtil.createJsonNode();
        ((ObjectNode) jsonObject).set("resultInfo", JsonUtil.toJsonNode(resultInfo));
        ((ObjectNode) jsonObject).set("data", JsonUtil.toJsonNode(data));
        return JsonUtil.toJsonString(jsonObject);
    }
}
