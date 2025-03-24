package com.example.Ecommerce.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter

public enum ErrorCode {
    AUTHENTICARIZE(9999,"authenticarize_error", HttpStatus.INTERNAL_SERVER_ERROR),

    USER_EXISTS(1001,"user existed",HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1002,"username phải có ừ 2 kí tự",HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(1003,"password phải có tối thiểu 8 kí tự",HttpStatus.BAD_REQUEST),
    INVALID_KEY(1004,"Invalid message Key",HttpStatus.BAD_REQUEST),
    USER_NOT_EXITS(1005,"Invalid message Key",HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006,"UNAUTHENTICATED",HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "You do not have permission", HttpStatus.FORBIDDEN),;
    private int code;
    private String message;
    private HttpStatusCode httpStatusCode;
    ErrorCode(int code, String message, HttpStatusCode httpStatusCode) {
        this.code = code;
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }





}
