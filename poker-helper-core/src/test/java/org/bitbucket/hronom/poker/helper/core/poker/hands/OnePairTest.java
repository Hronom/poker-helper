package org.bitbucket.hronom.poker.helper.core.poker.hands;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.CardDenominationType;
import org.bitbucket.hronom.poker.helper.core.cards.CardSuitType;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by hronom on 20.06.15.
 */
public class OnePairTest {
    @Test
    public void testIsAcceptableCombination() throws Exception {
        Card cards[] = new Card[] {
            new Card(CardSuitType.HEART, CardDenominationType.D9),
            new Card(CardSuitType.SPADE, CardDenominationType.D9),
            new Card(CardSuitType.HEART, CardDenominationType.D4),
            new Card(CardSuitType.CLUB, CardDenominationType.D4),
            new Card(CardSuitType.DIAMOND, CardDenominationType.D10)
        };

        OnePair onePair = new OnePair();
        assertTrue(onePair.isAcceptableCombination(cards));
    }
}