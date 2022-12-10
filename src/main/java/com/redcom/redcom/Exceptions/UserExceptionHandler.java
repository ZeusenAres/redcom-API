package com.redcom.redcom.Exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = {UserRequestException.class})
    public ResponseEntity<Object> handleUserRequestException(UserRequestException ure)
    {

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        UserException userException = new UserException(ure.getMessage(), badRequest, ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(userException, badRequest);
    }
}
