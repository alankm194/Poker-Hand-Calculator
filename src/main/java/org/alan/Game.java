package org.alan;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;


public class Game {

    private final Player player1;
    private final Player player2;
    private static final int FULL_HAND = 5;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getWinnerOfGame(){
        rankHand(player1.getHand());
        rankHand(player2.getHand());
        var handRank1 = player1.getHand().getHandRank();
        var handRank2 = player2.getHand().getHandRank();

        if (handRank2.getRank() > handRank1.getRank()) {
            return player2;
        } else {
            return player1;
        }
    }

    public void rankHand(Hand hand) {
        var listCards = hand.getCards();
        if (isStraightFlush(listCards)) {
            hand.setHandRank(HandRank.STRAIGHT_FLUSH);
        } else if (isFourOfAKind(listCards)) {
            hand.setHandRank(HandRank.FOUR_OF_A_KIND);
        } else if (isFullHouse(listCards)) {
            hand.setHandRank(HandRank.FULL_HOUSE);
        } else if (isFlush(listCards)) {
            hand.setHandRank(HandRank.FLUSH);
        } else if (isStraight(listCards)) {
            hand.setHandRank(HandRank.STRAIGHT);
        } else if (isThreeOfAKind(listCards)) {
            hand.setHandRank(HandRank.THREE_OF_A_KIND);
        } else if (isTwoPair(listCards)) {
            hand.setHandRank(HandRank.TWO_PAIR);
        } else if (isPair(listCards)) {
            hand.setHandRank(HandRank.PAIR);
        } else {
            hand.setHandRank(HandRank.HIGH_CARD);
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
        final int DISTINCT_FACES_FULLHOUSE = 2;
        var faceValuesList = listCards.stream()
                .map(Card::getFaceValue)
                .toList();

        var distinctFacesList = listCards.stream()
                .map(Card::getFaceValue)
                .distinct()
                .toList();
        if (distinctFacesList.size() != DISTINCT_FACES_FULLHOUSE) {
            return false;
        }
        var hasTriple = false;
        var hasDouble = false;
        for (FaceValues face : distinctFacesList) {
            hasTriple = hasTriple || Collections.frequency(faceValuesList, face) == TRIPLE;
            hasDouble = hasDouble || Collections.frequency(faceValuesList, face) == PAIR;
        }

        return hasTriple && hasDouble;
    }

    private boolean isFlush(List<Card> listCards) {
        var suitList = listCards.stream()
                .map(Card::getSuitValue)
                .toList();

        return suitList.stream()
                .anyMatch(i -> Collections.frequency(suitList, i) == FULL_HAND);

    }

    private boolean isStraight(List<Card> listCards) {
        var startFaceValue = listCards.get(0).getFaceValue().getValue();
        var faceValueList = listCards.stream()
                .map(e -> e.getFaceValue().getValue()).toList();

        var startToEnd = IntStream.range(startFaceValue, startFaceValue + FULL_HAND)
                .boxed()
                .toList();
        return faceValueList.equals(startToEnd);
    }

    private boolean isThreeOfAKind(List<Card> listCards) {
        final int THREE_OF_A_KIND = 3;
        var faceValuesList = listCards.stream()
                .map(Card::getFaceValue)
                .toList();
        return faceValuesList.stream()
                .anyMatch(i -> Collections.frequency(faceValuesList, i) == THREE_OF_A_KIND);
    }

    private boolean isTwoPair(List<Card> listCards) {
        final int TWO_PAIR = 2;
        final int PAIR = 2;
        var faceValuesList = listCards.stream()
                .map(Card::getFaceValue)
                .toList();

        return faceValuesList.stream()
                .filter(i -> Collections.frequency(faceValuesList, i) == PAIR)
                .distinct()
                .count() == TWO_PAIR;
    }

    private boolean isPair(List<Card> listCards) {
        final int PAIR = 2;
        final int ONE_PAIR = 1;

        var faceValuesList = listCards.stream()
                .map(Card::getFaceValue)
                .toList();

        return faceValuesList.stream()
                .filter(i -> Collections.frequency(faceValuesList, i) == PAIR)
                .distinct()
                .count() == ONE_PAIR;
    }
}
