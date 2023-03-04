package org.alan;

public enum HandRank {
    HIGH_CARD(1),
    PAIR(2),
    TWO_PAIR(3),
    THREE_OF_A_KIND(4),
    STRAIGHT(5),
    FLUSH(6),
    FULL_HOUSE(6),
    FOUR_OF_A_KIND(7),
    STRAIGHT_FLUSH(8);

    private final int rank;
    HandRank(int rank){
        this.rank = rank;
    }

    public int getRank(){
       return rank;
    }

}
