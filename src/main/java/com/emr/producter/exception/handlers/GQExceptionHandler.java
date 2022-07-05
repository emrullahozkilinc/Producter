package com.emr.producter.exception.handlers;

import com.emr.producter.exception.exceptions.PlayerNotFoundException;
import graphql.GraphQLError;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@Component
public class GQExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public GraphQLError handle(ConstraintViolationException e) {
        return new ThrowableGraphQLError(e);
    }

    @ExceptionHandler(PlayerNotFoundException.class)
    public GraphQLError handle(PlayerNotFoundException e) {
        return new ThrowableGraphQLError(e);
    }
}
