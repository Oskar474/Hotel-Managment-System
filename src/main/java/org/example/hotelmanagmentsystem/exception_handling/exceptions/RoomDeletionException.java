package org.example.hotelmanagmentsystem.exception_handling.exceptions;
public class RoomDeletionException extends CustomException {

    public RoomDeletionException(String message) {
        super(message, 404);
    }

}