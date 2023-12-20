package com.traning.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class myException extends RuntimeException {

    public myException() {
    }

    public myException(String message) {
        super(message);
    }

    public myException(String message, Throwable cause) {
        super(message, cause);
    }

    public myException(Throwable cause) {
        super(cause);
    }

    public myException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
