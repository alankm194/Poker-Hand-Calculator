package org.alan;

public class Card {

    private CardValues face;
    public Card(CardValues face) {
        this.face = face;
    }

    public CardValues getFaceValue() {
        return face;
    }
}
