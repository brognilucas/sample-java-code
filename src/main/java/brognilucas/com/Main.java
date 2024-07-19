package brognilucas.com;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BlackjackGame blackjackGame = new BlackjackGame();
        Deck deck = new Deck();
        deck.shuffleDeck();
        List<Card> playerHand = deck.dealCards(4);

        System.out.println("Player has made " + blackjackGame.calculatePoints(playerHand) + " points");
    }
}