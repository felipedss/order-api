package com.order.api.handler.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record ErrorResponseWrapper(List<ErrorResponseVO> errors) {

}