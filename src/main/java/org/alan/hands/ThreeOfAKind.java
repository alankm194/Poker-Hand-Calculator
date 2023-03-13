package org.alan.hands;

import org.alan.card.Card;
import org.alan.exceptions.InvalidHandException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeOfAKind extends Hand{

    private static final HandRank THREE_OF_A_KIND_HAND_RANK = HandRank.THREE_OF_A_KIND;

    private static final int TRIPLE = 3;

    private static final int KICKER = 1;


    public ThreeOfAKind(List<Card> currentHand) {
        super(currentHand);
    }

    @Override
    public HandRank getHandRank() {
        return THREE_OF_A_KIND_HAND_RANK;
    }

    @Override
    public int compareHands(Hand opponentsHand) throws InvalidHandException {
        if (THREE_OF_A_KIND_HAND_RANK.getRank() > opponentsHand.getHandRank().getRank()) {
            return 1;
        } else if(THREE_OF_A_KIND_HAND_RANK.getRank() < opponentsHand.getHandRank().getRank()) {
            return -1;
        }

        var myCards = this.getCards().stream().map(Card::getFaceValue).toList();
        var opponentCards = opponentsHand.getCards().stream().map(Card::getFaceValue).toList();

        var myTripleAndKickerMap = myCards
                .stream()
                .collect(Collectors.groupingBy(a -> Collections.frequency(myCards, a)));

        var opponentTripleAndKickerMap = opponentCards
                .stream()
                .collect(Collectors.groupingBy(a -> Collections.frequency(opponentCards, a)));

        var myTriple = myTripleAndKickerMap.get(TRIPLE)
                .stream()
                .distinct()
                .findFirst()
                .orElseThrow(() -> new InvalidHandException(this));

        var opponentTriple = opponentTripleAndKickerMap.get(TRIPLE)
                .stream()
                .distinct()
                .findFirst()
                .orElseThrow(() -> new InvalidHandException(opponentsHand));

        if (myTriple.compareTo(opponentTriple) > 0 ) {
            return 1;
        } else if (myTriple.compareTo(opponentTriple) < 0) {
            return -1;
        }

        var myKickerList = myTripleAndKickerMap.get(KICKER).stream().sorted().toList();
        var opponentKickerList = opponentTripleAndKickerMap.get(KICKER).stream().sorted().toList();

        for (int i = myKickerList.size()-1; i >= 0; i--) {
            if (myKickerList.get(i).compareTo(opponentKickerList.get(i)) > 0) {
                return 1;
            } else if (myKickerList.get(i).compareTo(opponentKickerList.get(i)) < 0) {
                return -1;
            }
        }
        return 0;
    }

}
