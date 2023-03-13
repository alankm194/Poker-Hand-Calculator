package org.alan.exceptions;

public class InvalidUserInputException extends Exception{


    private static final String MESSAGE_FORMAT = "User input is invalid.";

    public InvalidUserInputException() {
        super(MESSAGE_FORMAT);
    }

}
