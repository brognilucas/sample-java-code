package brognilucas.com;

import java.util.List;

public class BlackjackGame {
    public int calculatePoints(List<Card> playerHand) {
        int totalPoints = 0;
        int numberOfAces = 0;

        for (Card card : playerHand) {
            totalPoints += card.rank.getValue();
            if (card.rank == Rank.ACE) {
                numberOfAces++;
            }
        }

        while (totalPoints > 21 && numberOfAces > 0) {
            totalPoints -= 10;
            numberOfAces--;
        }

        return totalPoints;
    }
}
