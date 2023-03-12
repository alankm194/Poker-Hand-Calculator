package org.alan;

import org.alan.card.Card;
import org.alan.card.FaceValues;
import org.alan.hands.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RankHand {

    private static final int FULL_HAND = 5;

    public Hand rankHand(List<Card> listCards) {
        var sortedCards = listCards.stream().sorted().toList();
        if (isStraightFlush(sortedCards)) {
            return new StraightFlushHand(sortedCards);
        } else if (isFourOfAKind(sortedCards)) {
            return new FourOfAKindHand(sortedCards);
        } else if (isFullHouse(sortedCards)) {
            return new FullHouseHand(sortedCards);
        } else if (isFlush(sortedCards)) {
            return new FlushHand(sortedCards);
        } else if (isStraight(sortedCards)) {
            return new StraightHand(sortedCards);
        } else if (isThreeOfAKind(sortedCards)) {
            return new ThreeOfAKind(sortedCards);
        } else if (isTwoPair(sortedCards)) {
            return new TwoPairHand(sortedCards);
        } else if (isPair(sortedCards)) {
            return new PairHand(sortedCards);
        } else {
            return new HighCardHand(sortedCards);
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
