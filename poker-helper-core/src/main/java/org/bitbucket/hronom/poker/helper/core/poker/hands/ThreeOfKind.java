package org.bitbucket.hronom.poker.helper.core.poker.hands;

import org.bitbucket.hronom.poker.helper.core.cards.Card;
import org.bitbucket.hronom.poker.helper.core.poker.hands.utils.PokerHandsUtils;

/**
 * Сет/Триплет/Трипс/Тройка (англ. three of a kind, set — «три одинаковых», «набор»): три карты
 * одного достоинства, например: 7♣ 7♥ 7♠
 */
public class ThreeOfKind implements PokerHand {
    @Override
    public int getRating() {
        return 3;
    }

    @Override
    public boolean isAcceptableCombination(Card[] cards) {
        if (!PokerHandsUtils.checkOneDenomination(cards, 3)) {
            return false;
        }

        return true;
    }
}
