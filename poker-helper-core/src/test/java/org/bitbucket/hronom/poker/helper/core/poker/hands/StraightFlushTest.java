package org.bitbucket.hronom.poker.helper.core.poker.hands;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.CardDenominationType;
import org.bitbucket.hronom.poker.helper.core.cards.CardSuitType;
import org.bitbucket.hronom.poker.helper.core.cards.PokerDeck;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hronom on 20.06.15.
 */
public class StraightFlushTest {

    @Test
    public void testIsAcceptableCombination() throws Exception {
        Card cards[] = new Card[]{
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D5),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D6),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D7),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D8),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D9)
        };

        StraightFlush straightFlush = new StraightFlush();
        assertTrue(straightFlush.isAcceptableCombination(cards));
    }
}