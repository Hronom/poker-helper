package com.github.hronom.poker.helper.core.poker.hands;

import com.github.hronom.poker.helper.core.cards.Card;
import com.github.hronom.poker.helper.core.cards.CardDenominationType;
import com.github.hronom.poker.helper.core.cards.CardSuitType;
import com.github.hronom.poker.helper.core.cards.PokerDeck;
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
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D8),
            PokerDeck.getCard(CardSuitType.SPADE, CardDenominationType.D8),
            PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D4),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D4),
            PokerDeck.getCard(CardSuitType.DIAMOND, CardDenominationType.D10)
        };

        TwoPair twoPair = new TwoPair();
        assertTrue(twoPair.isAcceptableCombination(cards));
    }

    @Test
    public void testIsAcceptableCombination2() throws Exception {
        Card cards[] = new Card[] {
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D8),
            PokerDeck.getCard(CardSuitType.SPADE, CardDenominationType.D8),
            PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D4),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D5),
            PokerDeck.getCard(CardSuitType.DIAMOND, CardDenominationType.D10)
        };

        TwoPair twoPair = new TwoPair();
        assertFalse(twoPair.isAcceptableCombination(cards));
    }

    @Test
    public void testIsAcceptableCombination3() throws Exception {
        Card cards[] = new Card[] {
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D4),
            PokerDeck.getCard(CardSuitType.SPADE, CardDenominationType.D8),
            PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D4),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D8),
            PokerDeck.getCard(CardSuitType.DIAMOND, CardDenominationType.D8)
        };

        TwoPair twoPair = new TwoPair();
        assertTrue(twoPair.isAcceptableCombination(cards));
    }
}