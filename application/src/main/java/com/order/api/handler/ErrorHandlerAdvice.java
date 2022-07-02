package com.order.api.handler;

import com.order.api.handler.wrapper.ErrorResponseVO;
import com.order.api.handler.wrapper.ErrorResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.order.api.handler.ErrorCodes.CONSTRAINT_VIOLATION;

@RestControllerAdvice
public class ErrorHandlerAdvice {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseWrapper> handleConstraintViolationException(ConstraintViolationException exception) {

        List<ErrorResponseVO> errors = new ArrayList<>();

        exception.getConstraintViolations()
                .forEach(item -> errors.add(
                                new ErrorResponseVO(CONSTRAINT_VIOLATION.getCode(),
                                        CONSTRAINT_VIOLATION.name(),
                                        item.getMessage()
                                )
                        )
                );

        return buildErrorWrapper(HttpStatus.BAD_REQUEST, errors);
    }

    private ResponseEntity<ErrorResponseWrapper> buildErrorWrapper(
            String code,
            String rule,
            String message,
            HttpStatus statusCode) {
        ErrorResponseVO error = new ErrorResponseVO(code, rule, message);

        return buildErrorWrapper(statusCode, Collections.singletonList(error));
    }

    private ResponseEntity<ErrorResponseWrapper> buildErrorWrapper(
            HttpStatus statusCode,
            List<ErrorResponseVO> errors) {
        return ResponseEntity
                .status(statusCode)
                .body(new ErrorResponseWrapper(errors));
    }


}
