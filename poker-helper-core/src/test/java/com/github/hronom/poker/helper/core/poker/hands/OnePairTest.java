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
public class OnePairTest {
    @Test
    public void testIsAcceptableCombination() throws Exception {
        Card cards[] = new Card[] {
            PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D9),
            PokerDeck.getCard(CardSuitType.SPADE, CardDenominationType.D9),
            PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D4),
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D4),
            PokerDeck.getCard(CardSuitType.DIAMOND, CardDenominationType.D10)
        };

        OnePair onePair = new OnePair();
        assertTrue(onePair.isAcceptableCombination(cards));
    }
}