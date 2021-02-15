package com.conzax.fourcups.advice;

import com.conzax.fourcups.exception.AccountNotFoundException;
import com.conzax.fourcups.exception.TournamentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
class NotFoundAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public void accountNotFoundHandler(HttpServletResponse response, AccountNotFoundException exception) throws IOException {
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.getWriter().print(exception.getMessage());
    }

    @ExceptionHandler(TournamentNotFoundException.class)
    public void tournamentNotFoundHandler(HttpServletResponse response, TournamentNotFoundException exception) throws IOException {
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.getWriter().print(exception.getMessage());
    }
}
