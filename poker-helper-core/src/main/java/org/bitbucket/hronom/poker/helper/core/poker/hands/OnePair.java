package org.bitbucket.hronom.poker.helper.core.poker.hands;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.poker.hands.utils.PokerHandsUtils;

/**
 * Одна пара/Двойка (англ. one pair): две карты одного достоинства, например: 9♥ 9♠
 */
public class OnePair implements PokerHand {
    @Override
    public int getRating() {
        return 1;
    }

    @Override
    public boolean isAcceptableCombination(Card[] cards) {
        if (!PokerHandsUtils.checkOneDenomination(cards, 2)) {
            return false;
        }

        return true;
    }
}
