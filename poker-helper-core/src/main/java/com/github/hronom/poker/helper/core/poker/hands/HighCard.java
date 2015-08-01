package com.github.hronom.poker.helper.core.poker.hands;

import com.github.hronom.poker.helper.core.cards.Card;

/**
 * Старшая карта/Кикер (англ. high card): ни одна из вышеописанных комбинаций, например (комбинация
 * называется «старший туз»): Т♦ 10♦ 9♠ 5♣ 4♣.
 */
public class HighCard implements PokerHand {
    @Override
    public int getRating() {
        return 0;
    }

    @Override
    public boolean isAcceptableCombination(Card[] cards) {
        return true;
    }
}
