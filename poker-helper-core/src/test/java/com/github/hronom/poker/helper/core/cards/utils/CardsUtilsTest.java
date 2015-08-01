package com.github.hronom.poker.helper.core.cards.utils;

import com.github.hronom.poker.helper.core.cards.Card;
import com.github.hronom.poker.helper.core.cards.CardDenominationType;
import com.github.hronom.poker.helper.core.cards.CardSuitType;
import com.github.hronom.poker.helper.core.cards.PokerDeck;
import com.github.hronom.poker.helper.core.poker.hands.Flush;
import com.github.hronom.poker.helper.core.poker.hands.ThreeOfKind;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by hronom on 11.07.15.
 */
public class CardsUtilsTest {
    @Test
    public void testCountOutsCardsForTurn1() {
        ArrayList<Card> availableCards = new ArrayList<>();
        availableCards.add(PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D7));
        availableCards.add(PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D8));
        availableCards.add(PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.ACE));
        availableCards.add(PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D10));
        availableCards.add(PokerDeck.getCard(CardSuitType.SPADE, CardDenominationType.D3));

        long outs = CardsUtils.countOutsCardsForTurn(availableCards, new Flush());

        assertEquals(9, outs);
    }

    @Test
    public void testCountOutsCardsForTurn2() {
        ArrayList<Card> availableCards = new ArrayList<>();
        availableCards.add(PokerDeck.getCard(CardSuitType.SPADE, CardDenominationType.KING));
        availableCards.add(PokerDeck.getCard(CardSuitType.HEART, CardDenominationType.D9));
        availableCards.add(PokerDeck.getCard(CardSuitType.CLUB, CardDenominationType.QUEEN));
        availableCards.add(PokerDeck.getCard(CardSuitType.DIAMOND, CardDenominationType.D9));
        availableCards.add(PokerDeck.getCard(CardSuitType.SPADE, CardDenominationType.D2));

        long outs = CardsUtils.countOutsCardsForTurn(availableCards, new ThreeOfKind());

        assertEquals(2, outs);
    }
}