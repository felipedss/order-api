package com.order.api.handler.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record ErrorResponseVO(String code, String rule, String message) {

}