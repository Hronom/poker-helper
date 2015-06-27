package org.bitbucket.hronom.poker.helper.core.poker.hands.utils;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.CardDenominationType;
import org.bitbucket.hronom.poker.helper.core.cards.CardSuitType;
import org.bitbucket.hronom.poker.helper.core.cards.PokerDeck;
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
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D2),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D3),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D4),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D5),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D10)
        };

        assertTrue(PokerHandsUtils.checkOneSuit(cards, 5));
    }

    @Test
    public void testCheckOneSuit2() throws Exception {
        Card cards[] = new Card[] {
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D2),
            PokerDeck.getCard(CardSuitType.DIAMOND, CardDenominationType.D3),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D4),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D5),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D10)
        };

        assertFalse(PokerHandsUtils.checkOneSuit(cards, 5));
    }

    @Test
    public void testCheckOneSuit3() throws Exception {
        Card cards[] = new Card[] {
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D2),
            PokerDeck.getCard(CardSuitType.DIAMOND, CardDenominationType.D3),
            PokerDeck.getCard(CardSuitType.DIAMOND, CardDenominationType.D4),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D5),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D10)
        };

        assertTrue(PokerHandsUtils.checkOneSuit(cards, 2));
    }

    @Test
    public void testCheckOneDenomination1() throws Exception {
        Card cards[] = new Card[] {
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D10),
            PokerDeck.getCard(CardSuitType.DIAMOND, CardDenominationType.D10),
            PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D10),
            PokerDeck.getCard(CardSuitType.SPADE, CardDenominationType.D10),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.KING)
        };

        assertTrue(PokerHandsUtils.checkOneDenomination(cards, 4));
    }

    @Test
    public void testCheckOneDenomination2() throws Exception {
        Card cards[] = new Card[] {
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D10),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D9),
            PokerDeck.getCard(CardSuitType.DIAMOND, CardDenominationType.D10),
            PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D10),
            PokerDeck.getCard(CardSuitType.SPADE, CardDenominationType.D10)
        };

        assertFalse(PokerHandsUtils.checkOneDenomination(cards, 5));
    }

    @Test
    public void testCheckOneDenomination3() throws Exception {
        Card cards[] = new Card[] {
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D10),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D9),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D8),
            PokerDeck.getCard(CardSuitType.DIAMOND, CardDenominationType.D10),
            PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D10)
        };

        assertTrue(PokerHandsUtils.checkOneDenomination(cards, 3));
    }
}