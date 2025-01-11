package org.example.hotelmanagmentsystem.exception_handling.exceptions;

public abstract class CustomException extends RuntimeException {
    private final String message;
    private final int errorCode;

    public CustomException(String message, int errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
