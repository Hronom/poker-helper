package com.github.hronom.poker.helper.core.poker.hands;

import com.github.hronom.poker.helper.core.cards.Card;
import com.github.hronom.poker.helper.core.poker.hands.utils.PokerHandsUtils;

/**
 * Флаш (англ. flush — «масть») или «флеш»: пять карт одной масти, например: К♠ В♠ 8♠ 4♠ 3♠.
 */
public class Flush implements PokerHand {
    @Override
    public int getRating() {
        return 5;
    }

    @Override
    public boolean isAcceptableCombination(Card[] cards) {
        if (!PokerHandsUtils.checkOneSuit(cards, 5)) {
            return false;
        }

        return true;
    }
}
