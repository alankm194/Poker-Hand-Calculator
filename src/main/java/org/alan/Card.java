package org.alan;

import java.util.Comparator;
import java.util.Objects;

public class Card implements Comparable<Card> {

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

    @Override
    public String toString() {
        return String.format("face: %s suit: %s", face, suit);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return face == card.face && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(face, suit);
    }

    @Override
    public int compareTo(Card o) {
        return Comparator
                .comparing(Card::getFaceValue, Comparator.comparingInt(FaceValues::getValue))
                .thenComparing(Card::getSuitValue, Comparator.comparingInt(SuitValues::getValue))
                .compare(this, o);
    }

}
