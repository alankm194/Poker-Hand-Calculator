package org.alan;

public class Card {

    private FaceValues face;

    private SuitValues suit;
    public Card(FaceValues face, SuitValues suit) {
        this.face = face;
        this.suit = suit;
    }

    public SuitValues getSuitValue() {
        return suit;
    }

    public FaceValues getFaceValue() {
        return face;
    }
}
