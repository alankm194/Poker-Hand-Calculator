package org.alan;

public class Card {

    private FaceValues face;
    public Card(FaceValues face) {
        this.face = face;
    }

    public FaceValues getFaceValue() {
        return face;
    }
}
