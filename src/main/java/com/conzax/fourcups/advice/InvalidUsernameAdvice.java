package com.conzax.fourcups.advice;

import com.conzax.fourcups.exception.InvalidUsernameException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestControllerAdvice
class InvalidUsernameAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidUsernameException.class)
    public void invalidUsernameHandler(HttpServletResponse response, InvalidUsernameException exception) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }
}
