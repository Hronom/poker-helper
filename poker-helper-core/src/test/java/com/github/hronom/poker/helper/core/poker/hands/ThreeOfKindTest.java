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
public class ThreeOfKindTest {
    @Test
    public void testIsAcceptableCombination() throws Exception {
        Card cards[] = new Card[] {
            PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.D7),
            PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D7),
            PokerDeck.getCard(CardSuitType.SPADE, CardDenominationType.D7),
            PokerDeck.getCard(CardSuitType.DIAMOND, CardDenominationType.D3),
            PokerDeck.getCard(CardSuitType.DIAMOND, CardDenominationType.D10)
        };

        ThreeOfKind threeOfKind = new ThreeOfKind();
        assertTrue(threeOfKind.isAcceptableCombination(cards));
    }
}