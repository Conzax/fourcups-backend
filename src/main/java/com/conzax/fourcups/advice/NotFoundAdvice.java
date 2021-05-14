package com.conzax.fourcups.advice;

import com.conzax.fourcups.exception.AccountNotFoundException;
import com.conzax.fourcups.exception.EventNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.activation.MimeType;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestControllerAdvice
class NotFoundAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public void accountNotFoundHandler(HttpServletResponse response, AccountNotFoundException exception) throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(EventNotFoundException.class)
    public void tournamentNotFoundHandler(HttpServletResponse response, EventNotFoundException exception) throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, exception.getMessage());
    }
}
