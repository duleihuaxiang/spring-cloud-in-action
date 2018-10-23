package com.agan.book.config.exception;

public class EncryptException extends RuntimeException {

    private static final long serialVersionUID = -7896887327676105502L;

    public EncryptException(Exception e) {
        super(e);
    }

    public EncryptException(String msg) {
        super(msg);
    }

}
