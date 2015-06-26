package org.bitbucket.hronom.poker.helper.core.poker.hands;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.CardDenominationType;
import org.bitbucket.hronom.poker.helper.core.cards.CardSuitType;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by hronom on 20.06.15.
 */
public class TwoPairTest {
    @Test
    public void testIsAcceptableCombination1() throws Exception {
        Card cards[] = new Card[] {
            new Card(CardSuitType.CLUB, CardDenominationType.D8),
            new Card(CardSuitType.SPADE, CardDenominationType.D8),
            new Card(CardSuitType.HEART, CardDenominationType.D4),
            new Card(CardSuitType.CLUB, CardDenominationType.D4),
            new Card(CardSuitType.DIAMOND, CardDenominationType.D10)
        };

        TwoPair twoPair = new TwoPair();
        assertTrue(twoPair.isAcceptableCombination(cards));
    }

    @Test
    public void testIsAcceptableCombination2() throws Exception {
        Card cards[] = new Card[] {
            new Card(CardSuitType.CLUB, CardDenominationType.D8),
            new Card(CardSuitType.SPADE, CardDenominationType.D8),
            new Card(CardSuitType.HEART, CardDenominationType.D4),
            new Card(CardSuitType.CLUB, CardDenominationType.D5),
            new Card(CardSuitType.DIAMOND, CardDenominationType.D10)
        };

        TwoPair twoPair = new TwoPair();
        assertFalse(twoPair.isAcceptableCombination(cards));
    }

    @Test
    public void testIsAcceptableCombination3() throws Exception {
        Card cards[] = new Card[] {
            new Card(CardSuitType.CLUB, CardDenominationType.D4),
            new Card(CardSuitType.SPADE, CardDenominationType.D8),
            new Card(CardSuitType.HEART, CardDenominationType.D4),
            new Card(CardSuitType.CLUB, CardDenominationType.D8),
            new Card(CardSuitType.DIAMOND, CardDenominationType.D8)
        };

        TwoPair twoPair = new TwoPair();
        assertTrue(twoPair.isAcceptableCombination(cards));
    }
}