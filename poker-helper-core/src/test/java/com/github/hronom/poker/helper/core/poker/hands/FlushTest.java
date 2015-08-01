package com.github.hronom.poker.helper.core.poker.hands;

import com.github.hronom.poker.helper.core.cards.Card;
import com.github.hronom.poker.helper.core.cards.CardDenominationType;
import com.github.hronom.poker.helper.core.cards.CardSuitType;
import com.github.hronom.poker.helper.core.cards.PokerDeck;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by hronom on 20.06.15.
 */
public class FlushTest {

    @Test
    public void testIsAcceptableCombination() throws Exception {
        Card cards[] = new Card[] {
            PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.KING),
            PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.JACK),
            PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D8),
            PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D4),
            PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D3)
        };

        Flush flush = new Flush();
        assertTrue(flush.isAcceptableCombination(cards));
    }
}