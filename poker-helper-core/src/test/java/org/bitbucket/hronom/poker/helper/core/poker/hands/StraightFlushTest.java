package org.bitbucket.hronom.poker.helper.core.poker.hands;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.CardDenominationType;
import org.bitbucket.hronom.poker.helper.core.cards.CardSuitType;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hronom on 20.06.15.
 */
public class StraightFlushTest {

    @Test
    public void testIsAcceptableCombination() throws Exception {
        Card cards[] = new Card[]{
            new Card(CardSuitType.CLUB, CardDenominationType.D5),
            new Card(CardSuitType.CLUB, CardDenominationType.D6),
            new Card(CardSuitType.CLUB, CardDenominationType.D7),
            new Card(CardSuitType.CLUB, CardDenominationType.D8),
            new Card(CardSuitType.CLUB, CardDenominationType.D9)
        };

        StraightFlush straightFlush = new StraightFlush();
        assertTrue(straightFlush.isAcceptableCombination(cards));
    }
}