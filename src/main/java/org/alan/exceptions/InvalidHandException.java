package org.alan.exceptions;

import org.alan.hands.Hand;

public class InvalidHandException extends Exception{

    private static final String MESSAGE_FORMAT = "Hand %s is an invalid";

    public InvalidHandException(Hand hand) {
        super(String.format(MESSAGE_FORMAT, hand.getHandRank().toString()));
    }
}
