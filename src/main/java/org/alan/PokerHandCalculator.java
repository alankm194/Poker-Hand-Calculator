package org.alan;

import org.alan.card.Card;
import org.alan.card.FaceValues;
import org.alan.card.SuitValues;
import org.alan.exceptions.InvalidHandException;
import org.alan.exceptions.InvalidUserInputException;
import org.alan.hands.RankHand;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PokerHandCalculator {
    private static final String PLAYER_1 = "Player 1";
    private static final String PLAYER_2 = "Player 2";

    public static void main(String[] args) {
        PokerHandCalculator pokerCalculator = new PokerHandCalculator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Player 1 and Player 2 hands");
        System.out.println("example Player 1: 2H 3D 4S 5D AH  Player 2: AS AH KD QC 10C");
        while (true) {
            try {
                var playerInputMap = new UserInput().getPlayerCards();
               System.out.println(pokerCalculator.calculatePokerWinner(playerInputMap));
               System.out.println("Do you wish to enter another hand, Please enter yes or no");
               if (!scanner.nextLine().trim().equalsIgnoreCase("yes")) {
                   break;
               }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Please reenter hand");
            }
        }
    }

    public String calculatePokerWinner(Map<String, List<String>> playerInputMap) throws InvalidUserInputException, InvalidHandException {
        var player1CardList = translateStringHandIntoListOfCard(playerInputMap.get(PLAYER_1));
        var player2CardList = translateStringHandIntoListOfCard(playerInputMap.get(PLAYER_2));
        var rankHand = new RankHand();
        var player1 = new Player(PLAYER_1, rankHand.rankHand(player1CardList));
        var player2 = new Player(PLAYER_2, rankHand.rankHand(player2CardList));
        var winner = new Game().getWinnerOfGame(player1, player2);
        if (winner == null) {
            return String.format("Both hands have drawn with %s", player1.hand().getHandRank());
        } else {
            return String.format("the winner is %s with %s", winner.name(), winner.hand().getHandRank());
        }
    }

    private List<Card> translateStringHandIntoListOfCard(List<String> stringCardList) throws InvalidUserInputException {
        List<Card> playerCards = new ArrayList<>();

        for (String faceAndSuit : stringCardList) {
            var face = faceAndSuit.substring(0, faceAndSuit.length() - 1);
            var suit = faceAndSuit.substring(faceAndSuit.length() - 1);
            FaceValues faceValue = FaceValues.getFaceValueFromAbbreviation(face);
            if (faceValue == null) {
                throw new InvalidUserInputException("Face value is invalid " + face);
            }
            SuitValues suitValue = SuitValues.getFaceValueFromAbbreviation(suit);
            if (suitValue == null) {
                throw new InvalidUserInputException("Suit Value is invalid " + suit);
            }

            playerCards.add(new Card(faceValue, suitValue));
        }
        return playerCards;
    }

}
