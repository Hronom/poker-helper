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
public class FullHouseTest {
    @Test
    public void testIsAcceptableCombination1() throws Exception {
        Card cards[] = new Card[] {
            new Card(CardSuitType.HEART, CardDenominationType.D10),
            new Card(CardSuitType.DIAMOND, CardDenominationType.D10),
            new Card(CardSuitType.SPADE, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D8),
            new Card(CardSuitType.HEART, CardDenominationType.D8)
        };

        FullHouse fullHouse = new FullHouse();
        assertTrue(fullHouse.isAcceptableCombination(cards));
    }

    @Test
    public void testIsAcceptableCombination2() throws Exception {
        Card cards[] = new Card[] {
            new Card(CardSuitType.HEART, CardDenominationType.D9),
            new Card(CardSuitType.DIAMOND, CardDenominationType.D10),
            new Card(CardSuitType.SPADE, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D8),
            new Card(CardSuitType.HEART, CardDenominationType.D8)
        };

        FullHouse fullHouse = new FullHouse();
        assertFalse(fullHouse.isAcceptableCombination(cards));
    }

    @Test
    public void testIsAcceptableCombination3() throws Exception {
        Card cards[] = new Card[] {
            new Card(CardSuitType.HEART, CardDenominationType.D10),
            new Card(CardSuitType.DIAMOND, CardDenominationType.D10),
            new Card(CardSuitType.SPADE, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D10),
            new Card(CardSuitType.HEART, CardDenominationType.D10)
        };

        FullHouse fullHouse = new FullHouse();
        assertFalse(fullHouse.isAcceptableCombination(cards));
    }
}