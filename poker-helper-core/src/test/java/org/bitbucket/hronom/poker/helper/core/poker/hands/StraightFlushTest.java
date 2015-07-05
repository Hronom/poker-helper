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
public class StraightFlushTest {
    @Test
    public void testIsAcceptableCombination1() throws Exception {
        Card cards[] = new Card[6];
        cards[0] = PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D5);
        cards[1] = PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D6);
        cards[2] = PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D7);
        cards[3] = PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D8);
        cards[4] = PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D9);
        cards[5] = null;

        StraightFlush straightFlush = new StraightFlush();
        assertTrue(straightFlush.isAcceptableCombination(cards));
    }

    @Test
    public void testIsAcceptableCombination2() throws Exception {
        Card cards[] = new Card[] {
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D5),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D6),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D7),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D8),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D9)
        };

        StraightFlush straightFlush = new StraightFlush();
        assertTrue(straightFlush.isAcceptableCombination(cards));
    }

    @Test
    public void testIsAcceptableCombination3() throws Exception {
        Card cards[] = new Card[] {
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D5),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D6),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D7),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D8),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D9),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.ACE)
        };

        StraightFlush straightFlush = new StraightFlush();
        assertTrue(straightFlush.isAcceptableCombination(cards));
    }
}