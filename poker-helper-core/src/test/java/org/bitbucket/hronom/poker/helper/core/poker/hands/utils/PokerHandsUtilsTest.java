package org.bitbucket.hronom.poker.helper.core.poker.hands.utils;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.CardDenominationType;
import org.bitbucket.hronom.poker.helper.core.cards.CardSuitType;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by hronom on 26.06.15.
 */
public class PokerHandsUtilsTest {
    @Test
    public void testCheckOneSuit1() throws Exception {
        Card cards[] = new Card[] {
            new Card(CardSuitType.CLUB, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D10)
        };

        assertTrue(PokerHandsUtils.checkOneSuit(cards, 5));
    }

    @Test
    public void testCheckOneSuit2() throws Exception {
        Card cards[] = new Card[] {
            new Card(CardSuitType.CLUB, CardDenominationType.D10),
            new Card(CardSuitType.DIAMOND, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D10)
        };

        assertFalse(PokerHandsUtils.checkOneSuit(cards, 5));
    }

    @Test
    public void testCheckOneSuit3() throws Exception {
        Card cards[] = new Card[] {
            new Card(CardSuitType.CLUB, CardDenominationType.D10),
            new Card(CardSuitType.DIAMOND, CardDenominationType.D10),
            new Card(CardSuitType.DIAMOND, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D10)
        };

        assertTrue(PokerHandsUtils.checkOneSuit(cards, 2));
    }

    @Test
    public void testCheckOneDenomination1() throws Exception {
        Card cards[] = new Card[] {
            new Card(CardSuitType.CLUB, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D10)
        };

        assertTrue(PokerHandsUtils.checkOneDenomination(cards, 5));
    }

    @Test
    public void testCheckOneDenomination2() throws Exception {
        Card cards[] = new Card[] {
            new Card(CardSuitType.CLUB, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D9),
            new Card(CardSuitType.CLUB, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D10)
        };

        assertFalse(PokerHandsUtils.checkOneDenomination(cards, 5));
    }

    @Test
    public void testCheckOneDenomination3() throws Exception {
        Card cards[] = new Card[] {
            new Card(CardSuitType.CLUB, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D9),
            new Card(CardSuitType.CLUB, CardDenominationType.D8),
            new Card(CardSuitType.CLUB, CardDenominationType.D10),
            new Card(CardSuitType.CLUB, CardDenominationType.D10)
        };

        assertTrue(PokerHandsUtils.checkOneDenomination(cards, 3));
    }
}