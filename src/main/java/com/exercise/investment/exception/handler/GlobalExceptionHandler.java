package com.exercise.investment.exception.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.exercise.investment.exception.CommonException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CommonException.class)
    public String DeepLearningTrainExceptionHandler(Exception e) {
        return e.getMessage();
    }
}