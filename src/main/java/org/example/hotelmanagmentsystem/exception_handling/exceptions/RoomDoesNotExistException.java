package org.example.hotelmanagmentsystem.exception_handling.exceptions;

public class RoomDoesNotExistException extends CustomException{
    public RoomDoesNotExistException(String message) {
        super(message, 404);
    }
}
