package com.github.hronom.poker.helper.core.cards;

import java.util.ArrayList;

/**
 * Created by hronom on 27.06.15.
 */
public final class PokerDeck {
    public static final ArrayList<Card> cards = new ArrayList<>();

    static {
        for (CardSuitType suitType : CardSuitType.values()) {
            for (CardDenominationType denominationType : CardDenominationType.values()) {
                cards.add(new Card(suitType, denominationType));
            }
        }
    }

    private PokerDeck() {
    }

    public static Card getCard(
        CardSuitType cardSuitType, CardDenominationType cardDenominationType
    ) {
        for (Card card : cards) {
            if (card.suitType == cardSuitType && card.denominationType == cardDenominationType) {
                return card;
            }
        }

        return null;
    }
}