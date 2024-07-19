package brognilucas.com;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = this.initializeDeck();
    }

    private List<Card> initializeDeck() {
        List<Card> cards = new ArrayList<Card>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }

        return cards;
    }

    public List<Card> shuffleDeck() {
        List<Card> shuffledCards = new ArrayList<>(this.cards);
        int deckSize = shuffledCards.size();
        for(int i = 0 ; i < deckSize; i++) {
            int shuffledIndex = (int) (Math.random() * deckSize);
            Card currentCard = shuffledCards.get(i);
            Card shuffledCard = shuffledCards.get(shuffledIndex);

            shuffledCards.set(shuffledIndex, currentCard);
            shuffledCards.set(i, shuffledCard);
        }

        this.cards = shuffledCards;
        return this.cards;
    }

    public List<Card> dealCards(int numberOfCards){
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++) {
            Card card = this.cards.remove(i);
            hand.add(card);
        }
        return hand;
    }

    public int getDeckSize() {
        return this.cards.size();
    }

    public List<Card> getDeck() {
        return this.cards;
    }
}
