package org.alan.hands;

import org.alan.card.Card;
import org.alan.HandRank;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FourOfAKindHand extends Hand{

    private static final int FOUR_OF_A_KIND = 4;
    private static final int KICKER = 1;

    private static final HandRank FOUR_OF_A_KIND_HAND_RANK = HandRank.FOUR_OF_A_KIND;

    public FourOfAKindHand(List<Card> currentHand) {
        super(currentHand);
    }

    @Override
    public HandRank getHandRank() {
        return FOUR_OF_A_KIND_HAND_RANK;
    }

    @Override
    public int compareHands(Hand opponentsHand) {
        if (FOUR_OF_A_KIND_HAND_RANK.getRank() > opponentsHand.getHandRank().getRank()) {
            return 1;
        } else if (FOUR_OF_A_KIND_HAND_RANK.getRank() < opponentsHand.getHandRank().getRank()) {
            return -1;
        }

        var myCards = this.getCards().stream().map(Card::getFaceValue).toList();
        var opponentsCards = opponentsHand.getCards().stream().map(Card::getFaceValue).toList();

        var quadAndKickerMapPlayer1 = myCards
                .stream()
                .collect(Collectors.groupingBy(a -> Collections.frequency(myCards, a)));

        var quadAndKickerMapPlayer2 = opponentsCards
                .stream()
                .collect(Collectors.groupingBy(a -> Collections.frequency(opponentsCards, a)));

        var fourOfKindCardP1 = quadAndKickerMapPlayer1.get(FOUR_OF_A_KIND).stream()
                .distinct()
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        var fourOfKindCardP2 = quadAndKickerMapPlayer2.get(FOUR_OF_A_KIND).stream()
                .distinct()
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        if (fourOfKindCardP1.compareTo(fourOfKindCardP2) > 0) {
            return 1;
        } else if(fourOfKindCardP1.compareTo(fourOfKindCardP2) < 0) {
            return -1;
        } else {
            var kickerPlayer1 = quadAndKickerMapPlayer1.get(KICKER).get(0);
            var kickerPlayer2 = quadAndKickerMapPlayer2.get(KICKER).get(0);

            return Integer.compare(kickerPlayer1.compareTo(kickerPlayer2), 0);
        }


    }


}
