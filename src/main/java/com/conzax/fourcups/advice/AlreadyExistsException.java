package com.conzax.fourcups.advice;

import com.conzax.fourcups.exception.AccountAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
class AlreadyExistsException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccountAlreadyExistsException.class)
    public void tournamentNotFoundHandler(HttpServletResponse response, AccountAlreadyExistsException exception) throws IOException {
        response.setStatus(HttpStatus.CONFLICT.value());
        response.getWriter().print(exception.getMessage());
    }
}
