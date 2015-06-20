package org.bitbucket.hronom.poker.helper.core.poker.hands;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.cards.CardDenominationType;
import org.bitbucket.hronom.poker.helper.core.cards.CardSuitType;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by hronom on 20.06.15.
 */
public class StraightTest {

    @Test
    public void testIsAcceptableCombination() throws Exception {
        Card cards[] = new Card[] {
            new Card(CardSuitType.DIAMOND, CardDenominationType.D5),
            new Card(CardSuitType.HEART, CardDenominationType.D4),
            new Card(CardSuitType.SPADE, CardDenominationType.D3),
            new Card(CardSuitType.DIAMOND, CardDenominationType.D2),
            new Card(CardSuitType.DIAMOND, CardDenominationType.ACE)
        };

        Straight straight = new Straight();
        assertTrue(straight.isAcceptableCombination(cards));
    }
}