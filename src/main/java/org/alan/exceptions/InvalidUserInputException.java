package org.alan.exceptions;

public class InvalidUserInputException extends Exception{


    private static final String MESSAGE_FORMAT = "User input is invalid. %s";

    public InvalidUserInputException(String message) {
        super(String.format(MESSAGE_FORMAT, message));
    }

}
