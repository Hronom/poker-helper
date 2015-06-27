package org.bitbucket.hronom.poker.helper.core.poker.hands;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.CardDenominationType;
import org.bitbucket.hronom.poker.helper.core.cards.CardSuitType;
import org.bitbucket.hronom.poker.helper.core.cards.PokerDeck;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by hronom on 20.06.15.
 */
public class RoyalFlushTest {

    @Test
    public void testIsAcceptableCombination() throws Exception {
        Card cards[] = new Card[] {
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.ACE),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.KING),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.QUEEN),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.JACK),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D10)
        };

        RoyalFlush royalFlush = new RoyalFlush();
        assertTrue(royalFlush.isAcceptableCombination(cards));
    }
}