package brognilucas.com;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DeckTest {

    @Test
    public void test_create_deck(){
        Deck deck = new Deck();

        assertEquals (52, deck.getDeckSize(), "Deck should contain 52 cards");
    }

    @Test
    public void test_deck_all_unique_cards() {
        Deck deck = new Deck();
        Set<Card> uniqueCards = new HashSet<>(deck.getDeck());

        assertEquals(deck.getDeckSize(), uniqueCards.size(), "Deck should only have unique cards");
    }

    @Test
    public void test_should_shuffle_deck() {
        Deck deck = new Deck();
        List<Card> initialDeck = deck.getDeck();
        deck.shuffleDeck();
        assertNotEquals(deck.getDeck(), initialDeck, "Deck should be shuffled");
    }

    @Test
    public void shouldDealCards() {
        Deck deck = new Deck();

        deck.shuffleDeck();

        List<Card> hand = deck.dealCards(4);

        assertEquals(48, deck.getDeckSize(), "Deck should have 48 cards");
        assertEquals(4, hand.size(), "Hand should have 4 cards");
    }
}
