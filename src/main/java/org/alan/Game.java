package org.alan;

import java.util.Collections;
import java.util.List;

public class Game {

    private final Hand player1;
    private final Hand player2;

    private HandRank handRank;

    public Game(Hand player1, Hand player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Hand getPlayer1Hand() {
        return player1;
    }

    public Hand getPlayer2Hand() {
        return player2;
    }

    public void rankHand(Hand hand) {
        var listCards = hand.getHand();
        if (isStraightFlush(listCards)) {
            hand.setHandRank(HandRank.STRAIGHT_FLUSH);
        } else if (isFourOfAKind(listCards)) {
            hand.setHandRank(HandRank.FOUR_OF_A_KIND);
        } else if(isFullHouse(listCards)) {
            hand.setHandRank(HandRank.FULL_HOUSE);
        }
    }

    private boolean isStraightFlush(List<Card> listCards) {
        var currSequence = listCards.get(0).getFaceValue().getValue();
        var startingSuit = listCards.get(0).getSuitValue();
        for (int i = 1; i < listCards.size(); i++) {
            Card currentCard = listCards.get(i);
            if (currentCard.getSuitValue() != startingSuit) {
                return false;
            }
            int currentCardFaceValue = currentCard.getFaceValue().getValue();
            if (currentCardFaceValue != (currSequence + 1)) {
                return false;
            }
            currSequence += 1;
        }
        return true;
    }

    private boolean isFourOfAKind(List<Card> listCards) {
        final int FOUR_OF_A_KIND = 4;
        var faceValuesList = listCards.stream()
                .map(Card::getFaceValue)
                .toList();
        return faceValuesList.stream()
                .anyMatch(i -> Collections.frequency(faceValuesList, i) == FOUR_OF_A_KIND);
    }

    private boolean isFullHouse(List<Card> listCards) {
        final int TRIPLE = 3;
        final int PAIR = 2;
        var faceValuesList = listCards.stream()
                .map(Card::getFaceValue)
                .toList();

        var distinctFacesList = listCards.stream()
                .map(Card::getFaceValue)
                .distinct()
                .toList();
        if (distinctFacesList.size() != 2) {
            return false;
        }
        var hasTriple = false;
        var hasDouble = false;
        for (FaceValues face: distinctFacesList) {
            hasTriple = hasTriple || Collections.frequency(faceValuesList, face) == TRIPLE;
            hasDouble = hasDouble || Collections.frequency(faceValuesList, face) == PAIR;
        }

        return hasTriple && hasDouble;
    }
}
