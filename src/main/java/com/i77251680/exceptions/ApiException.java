package com.i77251680.exceptions;

public class ApiException extends RuntimeException {
    public int code;

    public ApiException(int code, String s) {
        super(s);
        this.code = code;
    }
}
