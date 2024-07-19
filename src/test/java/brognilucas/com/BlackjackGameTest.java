package brognilucas.com;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlackjackGameTest {

    @Test
    public void test_calculatePointCorrectly() {
        BlackjackGame blackjackGame = new BlackjackGame();
        List<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.CLUBS, Rank.EIGHT));
        hand.add(new Card(Suit.CLUBS, Rank.JACK));

        int totalPoints = blackjackGame.calculatePoints(hand);
        assertEquals(18, totalPoints, "Should total points to be 18 when hand has Jack + 8");
    }

    @Test
    public void test_aceShouldHaveValue11() {
        BlackjackGame blackjackGame = new BlackjackGame();
        List<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        int totalPoints = blackjackGame.calculatePoints(hand);
        assertEquals(11, totalPoints, "Should single ace have value 11");
    }



    @Test
    public void test_AceHasValue1IFSumOfOthersIsBiggerThan10() {
        BlackjackGame blackjackGame = new BlackjackGame();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.JACK));
        hand.add(new Card(Suit.CLUBS, Rank.TWO));
        hand.add(new Card(Suit.CLUBS, Rank.ACE));
        int totalPoints = blackjackGame.calculatePoints(hand);
        assertEquals(13, totalPoints, "Should ACE have value 1 when Sum of others is > 10");
    }
}
