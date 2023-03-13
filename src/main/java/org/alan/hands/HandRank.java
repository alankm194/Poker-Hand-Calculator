package org.alan.hands;

public enum HandRank {
    HIGH_CARD(1, "High card"),
    PAIR(2, "Pair"),
    TWO_PAIR(3, "Two pair"),
    THREE_OF_A_KIND(4, "Three of a kind"),
    STRAIGHT(5, "Straight"),
    FLUSH(6, "Flush"),
    FULL_HOUSE(6, "Full house"),
    FOUR_OF_A_KIND(7, "Four of a kind"),
    STRAIGHT_FLUSH(8, "Straight flush");

    private final int rank;

    private final String handRankString;
    HandRank(int rank, String handRankString){
        this.handRankString = handRankString;
        this.rank = rank;
    }

    public int getRank(){
       return rank;
    }

    @Override
    public String toString() {
        return handRankString;
    }

}
