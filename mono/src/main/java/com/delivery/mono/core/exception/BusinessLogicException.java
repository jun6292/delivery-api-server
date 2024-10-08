package com.delivery.mono.core.exception;

import lombok.Getter;

@Getter
public class BusinessLogicException extends RuntimeException{
    private ExceptionCode exceptionCode;

    public BusinessLogicException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }
}
