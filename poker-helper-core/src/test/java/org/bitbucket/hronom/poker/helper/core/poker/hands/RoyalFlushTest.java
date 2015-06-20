package org.bitbucket.hronom.poker.helper.core.poker.hands;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.CardDenominationType;
import org.bitbucket.hronom.poker.helper.core.cards.CardSuitType;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by hronom on 20.06.15.
 */
public class RoyalFlushTest {

    @Test
    public void testIsAcceptableCombination() throws Exception {
        Card cards[] = new Card[] {
            new Card(CardSuitType.CLUB, CardDenominationType.ACE),
            new Card(CardSuitType.CLUB, CardDenominationType.KING),
            new Card(CardSuitType.CLUB, CardDenominationType.QUEEN),
            new Card(CardSuitType.CLUB, CardDenominationType.JACK),
            new Card(CardSuitType.CLUB, CardDenominationType.D10)
        };

        RoyalFlush royalFlush = new RoyalFlush();
        assertTrue(royalFlush.isAcceptableCombination(cards));
    }
}