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
public class FullHouseTest {
    @Test
    public void testIsAcceptableCombination1() throws Exception {
        Card cards[] = new Card[] {
            PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D10),
            PokerDeck.getCard(CardSuitType.DIAMOND, CardDenominationType.D10),
            PokerDeck.getCard(CardSuitType.SPADE, CardDenominationType.D10),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D8),
            PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D8)
        };

        FullHouse fullHouse = new FullHouse();
        assertTrue(fullHouse.isAcceptableCombination(cards));
    }

    @Test
    public void testIsAcceptableCombination2() throws Exception {
        Card cards[] = new Card[] {
            PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D9),
            PokerDeck.getCard(CardSuitType.DIAMOND, CardDenominationType.D10),
            PokerDeck.getCard(CardSuitType.SPADE, CardDenominationType.D10),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D8),
            PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D8)
        };

        FullHouse fullHouse = new FullHouse();
        assertFalse(fullHouse.isAcceptableCombination(cards));
    }

    @Test
    public void testIsAcceptableCombination3() throws Exception {
        Card cards[] = new Card[] {
            PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D10),
            PokerDeck.getCard(CardSuitType.DIAMOND, CardDenominationType.D10),
            PokerDeck.getCard(CardSuitType.SPADE, CardDenominationType.D10),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D10),
            PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D10)
        };

        FullHouse fullHouse = new FullHouse();
        assertFalse(fullHouse.isAcceptableCombination(cards));
    }
}