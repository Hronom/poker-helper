package com.github.hronom.poker.helper.core.poker.hands;

import com.github.hronom.poker.helper.core.cards.Card;
import com.github.hronom.poker.helper.core.poker.hands.utils.PokerHandsUtils;

/**
 * Каре/Четвёрка/Покер (англ. four of a kind, quads — «четыре одинаковых»): четыре карты одного
 * достоинства, например: 3♥ 3♦ 3♣ 3♠.
 */
public class FourOfKind implements PokerHand {
    @Override
    public int getRating() {
        return 7;
    }

    @Override
    public boolean isAcceptableCombination(Card[] cards) {
        if (!PokerHandsUtils.checkOneDenomination(cards, 4)) {
            return false;
        }

        return true;
    }
}
